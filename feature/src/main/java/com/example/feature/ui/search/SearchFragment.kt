package com.example.feature.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.example.core.base.BaseFragment
import com.example.feature.R
import com.example.feature.databinding.FragmentSearchBinding
import com.example.feature.di.DaggerSearchComponent
import com.example.feature.di.SearchModule
import com.example.feature.viewmodel.SearchViewModel
import com.example.starwarsapp.App.Companion.coreComponent
class SearchFragment: BaseFragment<SearchViewModel>(
    R.layout.fragment_search
) {
    /**
     * Initialize dagger injection dependency graph.
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {

        super.onCreateView(inflater, container, savedInstanceState)

        val viewModelAdapter =
            MainAdapter({ viewModel.retry() }, MainAdapter.OnClickListener { film ->
                val destination =
                    Search
                with(findNavController()) {
                    currentDestination?.getAction(destination.actionId)
                        ?.let { navigate(destination) }
                }
            })

        viewModel.pagedList.observe(viewLifecycleOwner, {
            if (it.isEmpty() && binding.searchView.query.isEmpty()) {
                binding.emptyLayout.visibility = View.VISIBLE
            } else {
                binding.emptyLayout.visibility = View.INVISIBLE
            }
            viewModelAdapter.submitList(it)
        })

        viewModel.networkState.observe(viewLifecycleOwner, {
            viewModelAdapter.setNetworkState(it)
        })

        val searchCloseIconButtonId =
            resources.getIdentifier("android:id/search_close_btn", null, null)

        with(binding) {

            val searchClose: ImageView = searchView.findViewById(searchCloseIconButtonId)
            val searchCloseIconColor = ResourcesCompat.getColor(resources, R.color.gray, null)
            searchClose.setColorFilter(searchCloseIconColor)

            recyclerView.apply {
                setHasFixedSize(true)
                adapter = viewModelAdapter
            }

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    search(query)
                    return true
                }

                override fun onQueryTextChange(query: String): Boolean {
                    if (query.isNotEmpty()) {
                        search(query)
                        emptyLayout.visibility = View.INVISIBLE
                    } else if (recyclerView.adapter?.itemCount == 0) {
                        emptyLayout.visibility = View.VISIBLE
                    }
                    return true
                }
            })
        }
        return binding.root
    }

    override fun onInitDependencyInjection() {
        DaggerSearchComponent
            .builder()
            .coreComponent(coreComponent(requireContext()))
            .searchModule(SearchModule(this))
            .build()
            .inject(this)
    }

}
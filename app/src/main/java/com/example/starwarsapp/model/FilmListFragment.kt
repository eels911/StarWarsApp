package com.example.starwarsapp.model

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.R
import com.example.starwarsapp.ui.FilmAdapter
import com.example.starwarsapp.ui.FragmentFilmsListVM

class FilmListFragment: Fragment(R.layout.fragment_films_list) {
    private val viewModelFragment: FragmentFilmsListVM by lazy {
        ViewModelProvider(this).get(FragmentFilmsListVM::class.java)
    }
//    private val filmsAdapter: FilmAdapter by lazy{FilmAdapter(this)}

    private val searchTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun afterTextChanged(editable: Editable?) {
            // Start the search
//            viewModelFragment.onSearchQuery(editable.toString())
        }
    }
//        private val searchEditText: EditText by lazy {
//            requireView().findViewById<EditText>(R.id.searchEditText)
//        }
        private val rvFilms: RecyclerView by lazy {
            requireView().findViewById<RecyclerView>(R.id.rv_recycler).apply {
                layoutManager = LinearLayoutManager(context)
            }
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

//            rvFilms.adapter = filmsAdapter
//            viewModelFragment.filmsListLiveData.observe(viewLifecycleOwner) {
//                if (it.isEmpty()) showToast(R.string.bad_connection)
//                filmsAdapter.refresh(it ?: return@observe)
//            }
//            searchEditText.addTextChangedListener(searchTextWatcher)

        }

        private fun showToast(resId: Int) {
            Toast.makeText(requireContext(), getText(resId), Toast.LENGTH_SHORT).show()
        }

}
package com.example.feature.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.base.BaseFragment
import com.example.core.response.Character
import com.example.feature.R
import com.example.feature.databinding.FragmentDetailsBinding
import com.example.feature.viewmodel.DetailViewModel


import javax.inject.Inject

//Фрагмент с дополнительной информацией о герое
class DetailFragment: BaseFragment<DetailViewModel>(
    R.layout.fragment_details
) {
    @Inject
    lateinit var character: Character

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailedCharacterBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val characterAdapter = CharaterAdapter()
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onInitDependencyInjection() {
        TODO("Not yet implemented")
    }


}
package com.example.core.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment<VM: ViewModel>(
    @LayoutRes private val layoutId:Int
): Fragment() {
    @Inject
    lateinit var viewModel: VM


    /**
     * Called to initialize dagger injection dependency graph when fragment is attached.
     */
    protected abstract fun onInitDependencyInjection()

    /**
     * Called when a fragment is first attached to its context.
     *
     * @param context The application context.
     *
     * @see Fragment.onAttach
     */
    override fun onAttach(context: Context) {
        super.onAttach(context)
        onInitDependencyInjection()
    }

}
package com.example.feature.di

import com.example.core.di.CoreComponent
import com.example.core.di.FeatureScope
import com.example.feature.ui.search.SearchFragment
import dagger.Component

/**
 * Class for which a fully-formed, dependency-injected implementation is to
 * be generated from [SearchModule].
 *
 * @see Component
 */
@FeatureScope
@Component(modules = [SearchModule::class],
    dependencies = [CoreComponent::class]
)
interface SearchComponent {

    /**
     * Inject dependencies on component.
     *
     * @param searchFragment
     */
    fun inject(searchFragment: SearchFragment)
}
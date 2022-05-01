package com.example.starwarsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsapp.R
import com.example.starwarsapp.di.DaggerApiComponent
import com.example.starwarsapp.model.FilmListFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var filmAdapter: FilmAdapter
    private val filmViewModel: FragmentFilmsListVM by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerApiComponent.create().inject(this)
        setContentView(R.layout.activity_main)
        observeLiveData()

        val rvFilms : RecyclerView = findViewById(R.id.rv_recycler)

        rvFilms.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = filmAdapter
        }

//        if (savedInstanceState == null){
//            supportFragmentManager.beginTransaction()
//                .add(R.id.main_container, FilmListFragment())
//                .commit()
//        }
    }

    private fun observeVehicleList() {
        filmViewModel.filmsListLD.observe(this, Observer { allfilms ->
            allfilms.let {
//                rvFilms.visibility = View.VISIBLE
                filmAdapter.refresh(it)
            }
        })
    }

    private fun observeLiveData() {
        observeVehicleList()
    }
}
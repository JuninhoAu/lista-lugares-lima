package com.juni.limaguialugares.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juni.limaguialugares.detail.DetailFragment
import com.juni.limaguialugares.lista.ListFragment
import com.juni.limaguialugares.Places
import com.juni.limaguialugares.R


class MainActivity : AppCompatActivity(), ListFragment.PlacesInterface {

    private lateinit var detailFragment: DetailFragment
   //Hola como estas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        detailFragment=supportFragmentManager.findFragmentById(R.id.detalles_fragment) as DetailFragment

    }

    override fun placeSelect(places: Places) {

        detailFragment.setPlaces(places)


    }


}
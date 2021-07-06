package com.juni.limaguialugares.detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.juni.limaguialugares.Places
import com.juni.limaguialugares.R


class DetailFragment : Fragment() {

    private lateinit var image:ImageView
    private lateinit var boton:ImageView
    private lateinit var lugar:TextView
    private  var coordinates:String?=null
    private lateinit var progressBar:ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val  viewRoot= inflater.inflate(R.layout.fragment_detalles, container, false)
       image=viewRoot.findViewById(R.id.img_place)
       boton=viewRoot.findViewById(R.id.img_button)
       lugar=viewRoot.findViewById(R.id.img_ubi)
        progressBar=viewRoot.findViewById(R.id.pg_bar)

        boton.setOnClickListener {

//            Navigation.findNavController(viewRoot).navigate(R.id.placesDetailsFragment)


            coordinates?.let {
                val gmmIntentUri = Uri.parse("geo:0,0?q=$coordinates(Here)")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                //mapIntent.setPackage("com.google.android.apps.maps")
               // startActivity(mapIntent)
               // Navigation.findNavController(viewRoot).navigate(R.id.placesDetailsFragment)

                try {

                    startActivity(mapIntent)

                }catch ( ex: ActivityNotFoundException){

                    showMsg("debe instalar google maps para mostrar")

//Hola
                }



            }?: kotlin.run {

                showMsg("debe seleccionar una ubicación primero")
            }



        }


        return viewRoot
    }

    fun setPlaces(places: Places){

        lugar.text=places.name
        coordinates=places.coordenadas
        progressBar.visibility=View.VISIBLE
        Glide.with(this).load(places.url).listener(object :RequestListener<Drawable>{

            override fun onLoadFailed(e: GlideException?,
                                      model: Any?,
                                      target: Target<Drawable>?,
                                      isFirstResource: Boolean): Boolean {

                progressBar.visibility=View.GONE


               showMsg("carga fallida")


                return false
            }

            override fun onResourceReady(resource: Drawable?,
                                         model: Any?,
                                         target: Target<Drawable>?,
                                         dataSource: DataSource?,
                                         isFirstResource: Boolean): Boolean {

                progressBar.visibility=View.GONE


                return false
            }


        })//.error(R.drawable.ic_launcher_background)
                .into(image)


    }

    private fun showMsg(text:String){

        Toast.makeText(context,text,Toast.LENGTH_SHORT).show()

    }


}
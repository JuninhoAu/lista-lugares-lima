package com.juni.limaguialugares.detail

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.juni.limaguialugares.Places


class DetailFragment : Fragment() {

    private var placeName = mutableStateOf("Seleccione una opción de la lista")
    private var placeImage = mutableStateOf("")
    private var placeLocation = mutableStateOf("")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {

            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    PlaceDetailScreen(
                        placeName.value,
                        placeImage.value
                    ) { showMap(placeLocation.value) }
                }
            }

        }
    }

    fun setPlaces(places: Places) {
        placeName.value = places.name
        placeImage.value = places.url
        placeLocation.value = places.coordinates

    }

    private fun showMsg(text: String) {

        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }


    private fun showMap(coordinates: String?) {
        coordinates?.let {
            val gmmIntentUri = Uri.parse("geo:0,0?q=$coordinates(Here)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)

            try {
                startActivity(mapIntent)

            } catch (ex: ActivityNotFoundException) {
                showMsg("debe instalar google maps para mostrar")
            }

        } ?: kotlin.run {
            showMsg("debe seleccionar una ubicación primero")
        }

    }


}


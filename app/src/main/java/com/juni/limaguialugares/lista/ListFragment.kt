package com.juni.limaguialugares.lista

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.ViewModelProvider
import java.lang.ClassCastException


class ListFragment : Fragment() {

    private lateinit var placesInter: PlacesInterface


    override fun onAttach(context: Context) {
        super.onAttach(context)

        placesInter = try {

            context as PlacesInterface

        } catch (e: ClassCastException) {

            throw ClassCastException("implementation onAttach error")

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        return ComposeView(requireContext()).apply {

            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MaterialTheme {
                    ListScreen(viewModel, placesInter)
                }
            }

        }
    }


}
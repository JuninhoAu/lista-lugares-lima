package com.juni.limaguialugares.lista

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.juni.limaguialugares.Places
import com.juni.limaguialugares.R
import java.lang.ClassCastException


class ListFragment : Fragment() {

    interface PlacesInterface {

        fun placeSelect(places: Places)

    }

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
    ): View? {
        val viewRoot = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView = viewRoot.findViewById<RecyclerView>(R.id.recycler_items)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = FragmentAdapter()
        recyclerView.adapter = adapter

        val viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        viewModel.placeList.observe(viewLifecycleOwner, Observer {

                listPlace ->
            adapter.submitList(listPlace)


        })
        val divider = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(divider)


        adapter.hacerCLick = {

            placesInter.placeSelect(it)


        }


        return viewRoot
    }


}
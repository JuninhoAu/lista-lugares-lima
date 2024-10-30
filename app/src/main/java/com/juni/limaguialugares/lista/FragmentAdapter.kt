package com.juni.limaguialugares.lista

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.color.MaterialColors
import com.juni.limaguialugares.Places
import com.juni.limaguialugares.R


class FragmentAdapter :ListAdapter<Places, FragmentAdapter.ViewHolder>(DiffCallback){


    private var selectedItemPosition: Int = -1

    companion object DiffCallback: DiffUtil.ItemCallback<Places>(){

        override fun areItemsTheSame(oldItem: Places, newItem: Places): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Places, newItem: Places): Boolean {
            return oldItem == newItem
        }


    }

    lateinit var hacerCLick:(Places) -> Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.fragment_items,parent,false)
        return ViewHolder(view)


    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val places=getItem(position)

        val context = holder.itemView.context

        val color = MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnPrimary, Color.BLACK)

        holder.bind(places,position)


        if(selectedItemPosition==position){


            holder.itemView.setBackgroundColor( MaterialColors.getColor(context, com.google.android.material.R.attr.colorOnSecondary, Color.MAGENTA));

        }
        else
        {


            holder.itemView.setBackgroundColor(color);



        }



    }

    inner class ViewHolder(private val view:View):RecyclerView.ViewHolder(view){

        val LocName=view.findViewById<TextView>(R.id.text_item)
        val dis=view.findViewById<TextView>(R.id.text_item2)



        fun bind(places: Places, position: Int){

            dis.text=places.district
            LocName.text=places.name




            view.setOnClickListener {

                if (::hacerCLick.isInitialized){

                    hacerCLick(places)

                    selectedItemPosition = position

                    //notifyDataSetChanged()


                }
            }




        }


    }


}
package com.example.food_ordering_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LoginAdatpterClass(var songs:MutableList<LoginData>): RecyclerView.Adapter<LoginAdatpterClass.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.logintimestamp,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text1.text="${songs[position].loginTimestamp}"
       // holder.text2.text=songs[position].orderedDishes

        // Picasso.get().load(songs[position].url).into(holder.image);
    }

    override fun getItemCount(): Int {
        return songs.size
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //  val image=itemView.findViewById<ImageView>(R.id.image)
        val text1=itemView.findViewById<TextView>(R.id.LogintimeStamp)
        //val text2=itemView.findViewById<TextView>(R.id.textView5)
    }
}

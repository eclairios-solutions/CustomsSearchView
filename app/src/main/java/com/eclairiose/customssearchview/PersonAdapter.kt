package com.eclairiose.customssearchview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter (
    var list: ArrayList<Person>
) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            list[position]
        )
      // holder.name.text = person.name.trim()
    }

    override fun getItemCount(): Int = list.size

   /* inner class ViewHolder(private var item: temView) : RecyclerView.ViewHolder(item.root) {
        fun bind(person: Person) {
            item.name.text = person.name.trim()
            item.age.text = person.age.toString().trim()
        }
    }*/

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: Person) {
            val name = itemView.findViewById(R.id.name) as TextView
            val age  = itemView.findViewById(R.id.age) as TextView
            name.text = user.name.trim()
            age.text = user
                .age.toString().trim()

        }
    }
}
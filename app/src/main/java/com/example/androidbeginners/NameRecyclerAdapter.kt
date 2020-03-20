package com.example.androidbeginners

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_person_detail.view.*

//https://antonioleiva.com/recyclerview-listener/
class NameRecyclerAdapter(persons: ArrayList<Person>)
    : RecyclerView.Adapter<NameRecyclerAdapter.NameViewHolder>() {

    private val mPersons = persons
    private var listener: OnRecyclerItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_person_detail, parent, false)
        return NameViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mPersons.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(mPersons[position])
    }

    inner class NameViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val view = v

        fun bind(person: Person) {
            view.person_detail_id.text = person.id.toString()
            view.person_detail_text.text = person.name
            view.setOnClickListener {
                listener?.onClick(person)
            }
        }
    }

    fun setListener(listener: OnRecyclerItemClick) {
        this.listener = listener
    }

    interface OnRecyclerItemClick {
        fun onClick(person: Person)
    }
}
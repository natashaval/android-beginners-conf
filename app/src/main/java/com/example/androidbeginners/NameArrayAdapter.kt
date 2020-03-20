package com.example.androidbeginners

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_person.view.*
import java.util.ArrayList

class NameArrayAdapter(context: Context, persons: ArrayList<Person>): ArrayAdapter<Person>(context, 0, persons) {

    private val mPersons = persons

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val listItem = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false)
        listItem.person_text.text = mPersons[position].name
        return listItem
    }
}
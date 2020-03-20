package com.example.androidbeginners


import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.item_person.*
import timber.log.Timber
import java.io.Serializable

class ListFragment : Fragment() {

    private var persons: ArrayList<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            persons = it.getParcelableArrayList<Person>(KEY_PERSON)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListView()
    }

    private fun setListView() {
        Timber.d("Persons array: $persons")
        persons?.let {
//            val adapter = ArrayAdapter(activity!!, R.layout.item_person, R.id.person_text, it)
            val adapter = NameArrayAdapter(activity!!, it)
            list_view_layout.adapter = adapter
            list_view_layout.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(activity, "List Item clicked: ${it[position]}", Toast.LENGTH_SHORT).show()
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(persons: ArrayList<out Parcelable>) = ListFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(KEY_PERSON, persons)
            }
        }
    }
}

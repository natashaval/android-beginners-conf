package com.example.androidbeginners


import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_recycler.*
import timber.log.Timber

class RecyclerFragment : Fragment() {

    private var persons: ArrayList<Person>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            persons = it.getParcelableArrayList<Person>(KEY_PERSON)
        }
        Timber.d("Person in recycler $persons")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerAdapter()
    }

    private fun setUpRecyclerAdapter() {
        persons?.let {
            val mAdapter = NameRecyclerAdapter(it)
            mAdapter.setListener(object : NameRecyclerAdapter.OnRecyclerItemClick {
                override fun onClick(person: Person) {
                    Toast.makeText(activity, "Recycler Item clicked: $person", Toast.LENGTH_SHORT).show()
                }

            })
            recycler_view_layout.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = mAdapter
                addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(persons: ArrayList<out Parcelable>) = RecyclerFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(KEY_PERSON, persons)
            }
        }
    }
}

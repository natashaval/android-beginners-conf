package com.example.androidbeginners


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class DynamicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Timber.i("fragment onCreateView Called")
        return inflater.inflate(R.layout.fragment_dynamic, container, false)
    }

    override fun onStart() {
        super.onStart()
        Timber.i("fragment onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("fragment onResume Called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.i("fragment onAttach Called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("fragment onCreate Called")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("fragment onActivityCreated Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("fragment onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("fragment onStop Called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.i("fragment onDestroyView Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("fragment onDestroy Called")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.i("fragment onDetach Called")
    }
}

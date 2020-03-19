package com.example.androidbeginners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_two.*

class TwoActivity : AppCompatActivity() {

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        if (intent.hasExtra(KEY_COUNTER)) {
            counter = intent.getIntExtra(KEY_COUNTER, -1)
            counter2Text.text = resources.getString(R.string.counter_increase, counter)
        }

        switchFragmentClick()
    }

    private fun switchFragmentClick() {
        switchFragmentButton.setOnClickListener {
            fragmentManager
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentHost, DynamicFragment(), "")
                .commit()
        }
    }
}

package com.example.androidbeginners

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tab.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // create Fragment

        savedInstanceState?.let {
            counter = it.getInt(KEY_COUNTER)
            Timber.i("onCreate savedInstanceState %d", counter)
        }

        Timber.i("onCreate Called")
        counterText.text = resources.getString(R.string.counter_increase, counter)

        onCounterClicked()

        goToActivity()

        // instantiate view model
    }

    private fun goToActivity() {
        activity2Button.setOnClickListener {
            val intent = Intent(this, TwoActivity::class.java)
            intent.putExtra(KEY_COUNTER, counter)
            startActivity(intent)
        }

        product_button.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            intent.putExtra(KEY_COUNTER, counter)
            startActivity(intent)
        }

        tab_button.setOnClickListener {
            val intent = Intent(this, TabActivity::class.java)
            startActivity(intent)
        }

        send_mail_button.setOnClickListener {
            val intent = Intent(this, MailActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onCounterClicked() {
        counterButton.setOnClickListener {
            counter++
            counterText.text = resources.getString(R.string.counter_increase, counter)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(KEY_COUNTER)
        Timber.i("onRestoreInstanceState Called with Counter: %d", counter)
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, counter)
        Timber.i("onSaveInstanceState Called with Counter: %d", counter)
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }
}

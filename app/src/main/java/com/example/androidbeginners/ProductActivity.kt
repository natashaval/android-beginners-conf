package com.example.androidbeginners

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.fragment_detail.*
import timber.log.Timber

class ProductActivity : AppCompatActivity() {

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        Timber.i("product onCreate called")

        Timber.d("product extra %b", intent.hasExtra(KEY_COUNTER))
        if (intent.hasExtra(KEY_COUNTER)) {
            counter = intent.getIntExtra(KEY_COUNTER, -1)
        }
        Timber.d("product counter %d", counter)

        setUpFragment()
        onBuyClicked()
    }

    private fun onBuyClicked() {
        buy_button.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setIcon(R.drawable.ic_check_orange_24dp)
                .setTitle("Beli Sekarang")
                .setMessage("Yakin untuk membeli barang ini sekarang?")
                .setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->
                    Toast.makeText(this, "Pembelian dibatalkan!", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Yes") {dialog, id ->
                    Toast.makeText(this, "Pembelian berhasil!", Toast.LENGTH_SHORT).show()
                }
            dialog.show()
        }
    }

    private fun setUpFragment() {
        Timber.d("product %d", counter)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, DetailFragment.newInstance(counter, ""), "DetailFragment")
            .commit()
    }

    override fun onStart() {
        super.onStart()
        Timber.i("product onStart called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("product onResume called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("product onPause called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("product onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("product onDestroy called")
    }
}

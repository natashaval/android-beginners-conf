package com.example.androidbeginners

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpFragment()
        setContentView(R.layout.activity_product)

        onBuyClicked()
        setUpFragment()
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
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentBli, DetailFragment.newInstance("", ""))
            .commit()
    }
}

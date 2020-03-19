package com.example.androidbeginners


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_buy.*
import kotlinx.android.synthetic.main.item_reward.*
import kotlinx.android.synthetic.main.item_seller.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val productName = "Samsung Galaxy S10+ Smartphone Prism White [128 GB/ 8 GB]"
    val productUlasan = 4
    val productReward = 120
    val productBrand = "Samsung"
    val productPrice: Double = 11519000.0

    val sellerPenilaian = 98
    val sellerKota = "Jakarta Timur, DKI Jakarta"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private fun onJumlahClicked() {
        var beli = jumlah_beli_text.text.toString().toInt()
        jumlah_minus_button.setOnClickListener {
            if (beli > 0) {
                beli--
                jumlah_beli_text.text = beli.toString()
            }
        }
        jumlah_plus_button.setOnClickListener {
            beli++
            jumlah_beli_text.text = beli.toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setProductDetail()
        onJumlahClicked()
    }

    private fun setProductDetail() {
        product_text.text = productName
        brand_text.text = resources.getString(R.string.product_brand, productBrand)
        price_text.text = String.format("%,.2f", productPrice)
        ulasan_text.text = resources.getString(R.string.product_ulasan, productUlasan)
        reward_text.text = resources.getString(R.string.blibli_reward, productReward)

        penilaian_text.text = resources.getString(R.string.seller_nilai, sellerPenilaian)
        kota_text.text = resources.getString(R.string.seller_kota, sellerKota)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

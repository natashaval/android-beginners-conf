package com.example.androidbeginners


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_buy.*
import kotlinx.android.synthetic.main.item_reward.*
import kotlinx.android.synthetic.main.item_seller.*
import timber.log.Timber

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
    private var param1: Int? = null
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
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Timber.d("param1 %d", param1)
        Timber.i("fragment onCreate called")
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
        Timber.i("fragment onCreateView called")
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setProductDetail()
        onJumlahClicked()
        onRewardInfoClicked()
        onShareClicked()
    }

    private fun onRewardInfoClicked() {
        reward_info_text.setOnClickListener {
            val infoDialog = AlertDialog.Builder(activity!!)
            infoDialog.setTitle("Informasi Poin")
                .setMessage("Nilai poin yang tertera berlaku untuk transaksi dengan harga normal. Jika ada promo, nilai poin akan disesuaikan dengan harga promo yang berlaku")
                .show()
        }
    }

    private fun onShareClicked() {
        share_button.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, productName)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, "Hahaha")
            startActivity(shareIntent)
        }
    }

    private fun setProductDetail() {
        product_text.text = productName
        brand_text.text = resources.getString(R.string.product_brand, productBrand)
        price_text.text = String.format("%,.2f", productPrice)
//        ulasan_text.text = resources.getString(R.string.product_ulasan, productUlasan)
        ulasan_text.text = resources.getString(R.string.product_ulasan, param1)
        reward_text.text = resources.getString(R.string.blibli_reward, productReward)

        penilaian_text.text = resources.getString(R.string.seller_nilai, sellerPenilaian)
        kota_text.text = resources.getString(R.string.seller_kota, sellerKota)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

//    Lifecycle Fragment

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.i("fragment onActivityCreated Called")

        // if need to call activity (until finished) >> because fragment async
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

package com.component.androidcustomcomponent.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.component.androidcustomcomponent.customview.`interface`.DonationViewListener
import com.component.androidcustomcomponent.customview.`interface`.InvoiceViewListener
import com.component.androidcustomcomponent.customview.`interface`.ListHeaderViewListener
import com.component.androidcustomcomponent.customview.model.DonationModel
import com.yetkin.androidcustomcomponent.databinding.ActivityMainBinding
import com.component.androidcustomcomponent.util.extension.toastMessage

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        context = this

        //HeaderView
        binding.itemAll.apply {
            setListHeaderViewListener(object : ListHeaderViewListener {
                override fun onClickButton(type: String) {
                    "Click".toastMessage(context)
                }
            })
        }

        //DonationView
        binding.donationView.apply {
            val dataList = ArrayList<DonationModel>()
            dataList.add(DonationModel(0,"Donation","https://pbs.twimg.com/profile_images/989480289440337921/jY-4MT1p_400x400.jpg", "https://www.iklimhaber.org/wp-content/uploads/2020/06/ca-990x556.jpg", "Paycell Ormanı", "Geleceğini düşün  ağaç dik"))
            dataList.add(DonationModel(1,"Donation","https://www.pngkey.com/png/full/879-8796205_wwf-logo-beled-wwf-canada-logo.png", "https://i2.cnnturk.com/i/cnnturk/75/400x333/62c2989fbf21441c7837e114.jpg", "WWF", "Pandalara Yardım Eli Uzat"))
            dataList.add(DonationModel(2,"Donation","https://pbs.twimg.com/profile_images/989480289440337921/jY-4MT1p_400x400.jpg", "https://www.iklimhaber.org/wp-content/uploads/2020/06/ca-990x556.jpg", "Ormanı", "Geleceğini düşün  ağaç dik"))
            setData(dataList)

            setDonationViewListener(object : DonationViewListener {
                override fun onClick(id: Int, type: String) {
                    Toast.makeText(context, id.toString() + " Click", Toast.LENGTH_SHORT).show()
                }
            })
        }

        //InvoiceView
        binding.invoiceView.apply {
            setInvoiceViewListener(object : InvoiceViewListener {
                override fun onClickButton(type: String) {
                    "Button Click".toastMessage(context)
                }

                override fun onClickArrow() {
                    "Arrow Click".toastMessage(context)
                }
            })
        }
    }
}
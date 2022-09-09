package com.component.androidcustomcomponent.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.component.androidcustomcomponent.customview.`interface`.DonationViewListener
import com.component.androidcustomcomponent.customview.adapter.DonationAdapter
import com.component.androidcustomcomponent.customview.model.DonationModel
import com.yetkin.androidcustomcomponent.R
import com.yetkin.androidcustomcomponent.databinding.DonationViewBinding

class DonationView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defAttr: Int = 0
) : FrameLayout(context, attributes, defAttr) {

    private val binding: DonationViewBinding
    var listener: DonationViewListener? = null

    fun setDonationViewListener(listener: DonationViewListener) {
        this.listener = listener
    }

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DonationViewBinding.inflate(inflater)
        addView(binding.root)

        val attrs = context.obtainStyledAttributes(attributes, R.styleable.ListHeaderView)
        attrs.recycle()
    }

    fun setData(dataList: ArrayList<DonationModel>) {
        setAdapter(dataList)
    }

    private fun setAdapter(dataList: ArrayList<DonationModel>) {
        binding?.list?.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL ,false)
            adapter = DonationAdapter().also { adapter ->
                adapter.submitData(dataList)
                adapter.itemClick = { id, type ->
                    listener?.onClick(id, type)
                }
            }

        }
    }
}
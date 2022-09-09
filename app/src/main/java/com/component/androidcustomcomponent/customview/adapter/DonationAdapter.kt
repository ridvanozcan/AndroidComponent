package com.component.androidcustomcomponent.customview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.component.androidcustomcomponent.customview.model.DonationModel
import com.yetkin.androidcustomcomponent.R
import com.yetkin.androidcustomcomponent.databinding.DonationViewItemBinding

class DonationAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var viewDatas: MutableList<DonationModel> = ArrayList()
    var itemClick: ((id: Int, type: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.donation_view_item, parent, false
        )
        return StepIntroductionItemViewHolder(holderBinding)
    }

    override fun getItemCount(): Int = viewDatas.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? StepIntroductionItemViewHolder)?.onBind(getItem(position))
    }

    private fun getItem(position: Int) = viewDatas[position]

    fun submitData(list: List<DonationModel>) {
        this.viewDatas.clear()
        this.viewDatas.addAll(list)
        notifyDataSetChanged()
    }

    inner class StepIntroductionItemViewHolder(private val dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun onBind(viewData: DonationModel) {
            val binding = dataBinding as DonationViewItemBinding
            binding.item = viewData
            binding.cardView.setOnClickListener {
                itemClick?.invoke(viewData.id!!, viewData.type!!)
            }
        }
    }
}
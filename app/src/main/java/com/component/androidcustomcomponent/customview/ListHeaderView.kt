package com.component.androidcustomcomponent.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.yetkin.androidcustomcomponent.R
import com.component.androidcustomcomponent.customview.`interface`.ListHeaderViewListener
import com.yetkin.androidcustomcomponent.databinding.ListHeaderViewBinding

class ListHeaderView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defAttr: Int = 0
) : FrameLayout(context, attributes, defAttr) {

    private val binding: ListHeaderViewBinding
    var listener: ListHeaderViewListener? = null

    fun setListHeaderViewListener(listener: ListHeaderViewListener) {
        this.listener = listener
    }

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ListHeaderViewBinding.inflate(inflater)
        addView(binding.root)

        val attrs = context.obtainStyledAttributes(attributes, R.styleable.ListHeaderView)

        binding.apply {
            txtTitle = attrs.getString(R.styleable.ListHeaderView_txtTitle)
            txtButton = attrs.getString(R.styleable.ListHeaderView_txtButton)
            executePendingBindings()

            txtButton.apply {
                setOnClickListener {
                    listener?.onClickButton("ALL")
                }
            }
        }
        attrs.recycle()
    }
}
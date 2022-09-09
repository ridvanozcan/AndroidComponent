package com.component.androidcustomcomponent.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.component.androidcustomcomponent.customview.`interface`.InvoiceViewListener
import com.yetkin.androidcustomcomponent.R
import com.yetkin.androidcustomcomponent.databinding.InvoiceViewBinding

class InvoiceView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet? = null,
    defAttr: Int = 0
) : FrameLayout(context, attributes, defAttr) {

    private val binding: InvoiceViewBinding
    var listener: InvoiceViewListener? = null

    fun setInvoiceViewListener(listener: InvoiceViewListener) {
        this.listener = listener
    }

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = InvoiceViewBinding.inflate(inflater)
        addView(binding.root)

        val attrs = context.obtainStyledAttributes(attributes, R.styleable.InvoiceView)

        binding.apply {
            title = attrs.getString(R.styleable.InvoiceView_title)
            button = attrs.getString(R.styleable.InvoiceView_button)

            executePendingBindings()

            lottieLayerName.apply {
                setAnimation(attrs.getString(R.styleable.InvoiceView_lottieFile))
                playAnimation()
            }

            buttonInvoice.apply {
                setOnClickListener {
                    listener?.onClickButton("ALL")
                }
                setCompoundDrawablesWithIntrinsicBounds(R.drawable.hazir_param, 0, 0, 0)
            }

            menuArrow.apply {
                setOnClickListener {
                    listener?.onClickArrow()
                }
            }
        }
        attrs.recycle()
    }
}
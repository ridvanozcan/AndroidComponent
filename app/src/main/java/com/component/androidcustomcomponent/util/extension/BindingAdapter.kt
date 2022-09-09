package com.component.androidcustomcomponent.util.extension

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadDrawable")
fun ImageView.loadDrawable(img: String?) {
    Glide.with(this).load(img).into(this)
}

@BindingAdapter("buttonText")
fun buttonText(view: TextView, text: String?) {
    if (text.isNullOrEmpty())
        view.visibility = View.INVISIBLE
    else
        view.text = text
}
package com.component.androidcustomcomponent.customview.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DonationModel(
    var id: Int?,
    var type: String?,
    var logo: String?,
    var background: String?,
    var title: String?,
    var description: String?
) : Parcelable

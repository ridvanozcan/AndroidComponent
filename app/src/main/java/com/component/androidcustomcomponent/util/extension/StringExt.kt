package com.component.androidcustomcomponent.util.extension

import android.content.Context
import android.widget.Toast

fun String.toastMessage(context: Context) = Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
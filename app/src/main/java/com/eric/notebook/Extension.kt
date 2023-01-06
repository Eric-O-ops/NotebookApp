package com.eric.notebook

import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.text.SimpleDateFormat
import java.util.*

fun Fragment.navigate(@IdRes id: Int) = findNavController().navigate(id)

fun Fragment.loge(tag: String, massage: String) = Log.e(tag, massage)

fun Fragment.getTime(): String =
    SimpleDateFormat("HH:mm", Locale.getDefault()).format(Calendar.getInstance().time)

fun Fragment.getDate(): String =
    SimpleDateFormat("d MMMM", Locale.getDefault()).format(Calendar.getInstance().time)
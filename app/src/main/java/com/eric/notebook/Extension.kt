package com.eric.notebook

import android.util.Log
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(@IdRes id: Int) = findNavController().navigate(id)

fun Fragment.loge(tag: String, massage: String) = Log.e(tag, massage)
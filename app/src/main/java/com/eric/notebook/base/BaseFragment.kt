package com.eric.notebook.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(@LayoutRes idLayout: Int) :
    Fragment(idLayout) {

    protected abstract val binding: VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListener()
        setupSubscribes()
        setupView()
    }

    protected open fun initialize() {}

    protected open fun setupListener() {}

    protected open fun setupSubscribes() {}

    protected open fun setupView() {}
}


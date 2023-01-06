package com.eric.notebook.ui.fragments.onboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.databinding.FragmentMainOnBoardBinding
import com.eric.notebook.ui.adapters.OnBoardAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardMainFragment : Fragment(R.layout.fragment_main_on_board) {

    private val binding by viewBinding(FragmentMainOnBoardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() = with(binding) {
        viewPager.adapter = OnBoardAdapter(this@OnBoardMainFragment)
        dotsIndicator.setViewPager(viewPager)

    }
}
package com.eric.notebook.ui.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.eric.notebook.ui.fragments.onboard.OnBoardFragment

class OnBoardAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment =
        OnBoardFragment().apply {
            arguments = Bundle().apply {
                putInt(OnBoardFragment.VIEW_PAGE_POSITION_KEY, position)
            }
        }
}
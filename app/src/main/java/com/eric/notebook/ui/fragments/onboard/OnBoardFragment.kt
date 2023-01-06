package com.eric.notebook.ui.fragments.onboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.data.local.preferences.userdata.UserPreferenceData
import com.eric.notebook.databinding.FragmentOnBoardBinding
import com.eric.notebook.navigate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment(R.layout.fragment_on_board) {

    @Inject
    lateinit var userPreferenceData: UserPreferenceData
    private val binding by viewBinding(FragmentOnBoardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changeViewPageRes()
        goToMainFragment()
    }

    private fun changeViewPageRes() = with(binding) {
        val position = requireArguments().getInt(VIEW_PAGE_POSITION_KEY)
        val firstScreen = 0
        val secondScreen = 1
        val thirdScreen = 2

        when (position) {

            firstScreen -> {
                animationView.setAnimation("anim_image_1.json")
                tvAnimViewDescription.setText(R.string.anim_view_description_1)
            }
            secondScreen -> {
                animationView.setAnimation("anim_image_2.json")
                tvAnimViewDescription.setText(R.string.anim_view_description_2)
            }
            thirdScreen -> {
                animationView.setAnimation("anim_image_3.json")
                tvAnimViewDescription.setText(R.string.anim_view_description_3)
                btnSkipOnBoard.visibility = View.GONE
                tvStartWork.visibility = View.VISIBLE
            }
        }
    }

    private fun goToMainFragment() = with(binding) {
        val goToMainFragment = fun() {
            userPreferenceData.onBoard = true
            navigate(R.id.action_mainOnBoardFragment_to_mainFragment)
        }

        btnSkipOnBoard.setOnClickListener {
            goToMainFragment()
        }

        tvStartWork.setOnClickListener {
            goToMainFragment()
        }
    }

    companion object {
        const val VIEW_PAGE_POSITION_KEY = "position"
    }
}
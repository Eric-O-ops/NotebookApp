package com.eric.notebook.ui.fragments.main.addnote

import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentAddNoteBinding
import com.eric.notebook.getDate
import com.eric.notebook.getTime
import com.eric.notebook.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<FragmentAddNoteBinding>(R.layout.fragment_add_note) {

    override val binding by viewBinding(FragmentAddNoteBinding::bind)
    private var noteBackgroundColor = "#191818"
    private var title = ""

    override fun setupListener() {

        createNote()
        setBackgroundColorNote()
    }

    override fun setupView() = with(binding) {
        btnBackAndDate.text = getDate()
        tvTime.text = getTime()
    }

    private fun createNote() {
        binding.btnCreateNote.setOnClickListener {

            navigate(R.id.action_addNoteFragment_to_mainFragment)
        }
    }

    private fun setBackgroundColorNote() = with(binding) {
        btnColor1.setOnClickListener {
            radioBtnPosition1.isChecked = true
            noteBackgroundColor = "#191818"
        }

        btnColor2.setOnClickListener {
            radioBtnPosition2.isChecked = true
            noteBackgroundColor = "#EBE4C9"
        }

        btnColor3.setOnClickListener {
            radioBtnPosition3.isChecked = true
            noteBackgroundColor = "571818"
        }
    }

    private fun getTitle() = with(binding) {
        val charSentence = etDescriptionNote.text.toString().toCharArray()

        for (i in 0..30) {
            title += charSentence[i].toString()
        }
    }
}
package com.eric.notebook.ui.fragments.main.addnote

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentAddNoteBinding
import com.eric.notebook.getDate
import com.eric.notebook.getTime
import com.eric.notebook.models.NoteModel
import com.eric.notebook.navigate
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddNoteFragment :
    BaseFragment<FragmentAddNoteBinding, AddNoteViewModel>(R.layout.fragment_add_note) {

    override val binding by viewBinding(FragmentAddNoteBinding::bind)
    override val viewModel: AddNoteViewModel by viewModels()
    private var noteBackgroundColor = "#191818"

    override fun setupListener() {

        createNote()
        setBackgroundColorNote()
    }

    override fun setupView() = with(binding) {
        btnBackAndDate.text = getDate()
        tvTime.text = getTime()
    }

    private fun createNote() = with(binding) {
        btnCreateNote.setOnClickListener {
            getTitle()
            lifecycleScope.launch {
                viewModel.addNote(
                    NoteModel(
                        title = getTitle(),
                        description = etDescriptionNote.text.toString(),
                        time = tvTime.text.toString(),
                        date = btnBackAndDate.text.toString(),
                        backgroundColor = noteBackgroundColor
                    )
                )
            }
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
            noteBackgroundColor = "#571818"
        }
    }

    private fun getTitle(): String {
        val charSentence = binding.etDescriptionNote.text.toString().toCharArray()
        var title = ""

        for (i in 0..30) {
            title += charSentence[i].toString()
        }
        return title
    }
}
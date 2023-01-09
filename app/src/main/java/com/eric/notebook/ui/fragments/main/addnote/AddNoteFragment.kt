package com.eric.notebook.ui.fragments.main.addnote

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentAddNoteBinding
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
    private var title = ""
    private var description = ""

    override fun setupListener() {

        createNote()
        setBackgroundColorNote()
    }

    override fun setupView() = with(binding) {
        btnBackAndDate.text = DataToday.Base().getData()
        tvTime.text = TimeRightNow.Base().getTime()
    }

    private fun createNote() = with(binding) {
        btnCreateNote.setOnClickListener {
            if (etDescriptionNote.length() != 0) {
                description = etDescriptionNote.text.toString()
                title = TitleFromDescription.Base().getTitle(description)
                lifecycleScope.launch {
                    viewModel.addNote(
                        NoteModel(
                            date = btnBackAndDate.text.toString(),
                            time = tvTime.text.toString(),
                            title = title,
                            description = description,
                            backgroundColor = noteBackgroundColor
                        )
                    )
                }
                navigate(R.id.action_addNoteFragment_to_mainFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    R.string.toast_add_description,
                    Toast.LENGTH_SHORT
                ).show()
            }
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
}
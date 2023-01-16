package com.eric.notebook.ui.fragments.main.addnote

import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentAddNoteBinding
import com.eric.notebook.models.NoteModel
import com.eric.notebook.navigate
import com.eric.notebook.ui.fragments.main.BackgroundColorNote
import com.eric.notebook.ui.fragments.main.DataTime
import com.eric.notebook.ui.fragments.main.TitleAndDescription
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment :
    BaseFragment<FragmentAddNoteBinding, AddNoteViewModel>(R.layout.fragment_add_note) {

    override val binding by viewBinding(FragmentAddNoteBinding::bind)
    override val viewModel: AddNoteViewModel by viewModels()
    private val backgroundColorNote = BackgroundColorNote.Base()

    override fun setupListener() {

        createNote()
        setBackgroundColorNote()
    }

    override fun setupView() = with(binding) {
        btnBackAndDate.text = DataTime.Base().data()
        tvTime.text = DataTime.Base().time()
    }

    private fun createNote() = with(binding) {
        btnCreateNote.setOnClickListener {
            val descriptionAndTitle = TitleAndDescription.Base(etDescriptionNote.text.toString())
            if (etDescriptionNote.length() != 0) {
                viewModel.addNote(
                    NoteModel(
                        date = btnBackAndDate.text.toString(),
                        time = tvTime.text.toString(),
                        title = descriptionAndTitle.title(),
                        description = descriptionAndTitle.description(),
                        backgroundColor = backgroundColorNote.backgroundColor()
                    )
                )
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
            backgroundColorNote.position(radioBtnPosition1)
        }

        btnColor2.setOnClickListener {
            backgroundColorNote.position(radioBtnPosition2)
        }

        btnColor3.setOnClickListener {
            backgroundColorNote.position(radioBtnPosition3)
        }
    }
}
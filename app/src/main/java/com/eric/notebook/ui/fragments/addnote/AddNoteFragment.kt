package com.eric.notebook.ui.fragments.addnote

import android.app.AlertDialog
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentAddNoteBinding
import com.eric.notebook.models.NoteModel
import com.eric.notebook.navigate
import com.eric.notebook.ui.fragments.detail.BackgroundColorNote
import com.eric.notebook.ui.fragments.detail.DataTime
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

    // add note when fragment destroys
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
                findNavController().popBackStack()
            } else {
                Toast.makeText(
                    requireContext(),
                    R.string.toast_add_description,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnBackAndDate.setOnClickListener {
            if (!etDescriptionNote.text.isNullOrEmpty()) {
                AlertDialog.Builder(requireContext())
                    .setCancelable(false)
                    .setMessage("Вы хотите сохранить заметку ?")
                    .setPositiveButton(R.string.alert_dialog_main_positive_button_text) { _, _ ->
                        val descriptionAndTitle =
                            TitleAndDescription.Base(etDescriptionNote.text.toString())
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
                    }
                    .setNegativeButton(R.string.alert_dialog_main_negative_button) { _, _ ->
                        findNavController().popBackStack()
                    }
                    .create().show()
            } else {
                findNavController().popBackStack()
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

    override fun onDestroy() {
        super.onDestroy()


    }
}
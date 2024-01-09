package com.eric.notebook.ui.fragments.detail

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentDetailBinding
import com.eric.notebook.ui.fragments.main.TitleAndDescription
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<FragmentDetailBinding, DetailViewModel>(R.layout.fragment_detail) {

    override val binding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel: DetailViewModel by viewModels()
    private val safeArgs: DetailFragmentArgs by navArgs()
    private var backgroundColorNote = BackgroundColorNote.Base()

    override fun setupView() = with(binding) {
        val note = viewModel.loadNoteById(safeArgs.noteId)
        etDescriptionNote.setText(note.description)
        btnBackAndDate.text = DataTime.Base().data()
        tvTime.text = DataTime.Base().time()
        when (note.backgroundColor) {
            "#191818" -> {
                backgroundColorNote.position(radioBtnPosition1)
            }

            "#EBE4C9" -> {
                backgroundColorNote.position(radioBtnPosition2)
            }

            else -> {
                backgroundColorNote.position(radioBtnPosition3)
            }
        }
    }

    override fun setupListener() = with(binding) {
        setBackgroundColorNote()
        val note = viewModel.loadNoteById(safeArgs.noteId)
        btnBackAndDate.setOnClickListener {
            val titleAndDescription = TitleAndDescription.Base(etDescriptionNote.text.toString())
            if (etDescriptionNote.length() != 0) {
                viewModel.refreshNote(
                    note.copy(
                        time = "${tvTime.text} (redacted)",
                        date = btnBackAndDate.text.toString(),
                        title = titleAndDescription.title(),
                        description = titleAndDescription.description(),
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
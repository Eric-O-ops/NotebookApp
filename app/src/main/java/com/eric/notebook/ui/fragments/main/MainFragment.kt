package com.eric.notebook.ui.fragments.main

import android.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentMainBinding
import com.eric.notebook.loge
import com.eric.notebook.models.NoteModel
import com.eric.notebook.navigate
import com.eric.notebook.ui.adapters.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main),
    MainEvents {

    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()
    private val noteAdapter =
        NoteAdapter(shortClick = this::detailNote, longClick = this::removeNote)

    override fun initialize() {
        loadNoteList()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    override fun setupListener() {
        addNote()
    }

    override fun loadNoteList() {
        viewModel.loadAllNote().observe(viewLifecycleOwner) { notes ->
            noteAdapter.submitList(notes)
        }
    }

    override fun addNote() {
        binding.btnAddNote.setOnClickListener {
            navigate(R.id.action_mainFragment_to_addNoteFragment)
        }
    }

    override fun detailNote(id: Int) {
        loge("MainFragment", "shortClick: $id")
    }

    override fun removeNote(note: NoteModel) {
        AlertDialog.Builder(requireContext())
            .setCancelable(false)
            .setTitle(R.string.alert_dialog_main_title)
            .setMessage(R.string.alert_dialog_main_massage)
            .setPositiveButton(R.string.alert_dialog_main_positive_button_text) { _, _ ->
                viewModel.removeNote(note)
            }
            .setNegativeButton(R.string.alert_dialog_main_negative_button) { _, _ -> }
            .create().show()

        loge("MainFragment", "longClick noteId: ${note.id}")
    }
}
package com.eric.notebook.ui.fragments.main

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentMainBinding
import com.eric.notebook.navigate
import com.eric.notebook.ui.adapters.NoteAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()
    private val noteAdapter = NoteAdapter()

    override fun initialize() {
        loadNoteList()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun loadNoteList() {
        viewModel.loadAllNote().observe(viewLifecycleOwner) {
            noteAdapter.setList(it)
        }
    }

    override fun setupListener() {
        addNote()
    }

    private fun addNote() {
        binding.btnAddNote.setOnClickListener {
            navigate(R.id.action_mainFragment_to_addNoteFragment)
        }
    }
}
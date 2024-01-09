package com.eric.notebook.ui.fragments.main

import android.app.AlertDialog
import android.util.Log
import android.view.View
import androidx.core.view.GravityCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.eric.notebook.R
import com.eric.notebook.base.BaseFragment
import com.eric.notebook.databinding.FragmentMainBinding
import com.eric.notebook.models.NoteModel
import com.eric.notebook.navigate
import com.eric.notebook.ui.adapters.layoutmode.NoteAdapter
import com.eric.notebook.ui.adapters.layoutmode.NoteAdapterStaggeredGrid
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment :
    BaseFragment<FragmentMainBinding, MainViewModel>(R.layout.fragment_main), MainEvents {

    override val binding by viewBinding(FragmentMainBinding::bind)
    override val viewModel: MainViewModel by viewModels()
    private val noteAdapter =
        NoteAdapter(shortClick = this::detailNote, longClick = this::removeNote)
    private val noteStaggeredAdapter =
        NoteAdapterStaggeredGrid(shortClickSG = this::detailNote, longClickSG = this::removeNote)

    override fun initialize(): Unit = with(binding) {

        noteAdapter.setContext(requireContext())
        noteStaggeredAdapter.setContext(requireContext())

        viewModel.isLinearLayout().apply {
            if (this) {
                recyclerViewLinear.visibility = View.VISIBLE
                changeLayout.setBackgroundResource(R.drawable.ic_grid_layout)
            } else {
                recyclerViewStaggeredGrid.visibility = View.VISIBLE
                changeLayout.setBackgroundResource(R.drawable.ic_linear_layout)
            }
        }

        recyclerViewLinear.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }

        recyclerViewStaggeredGrid.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = noteStaggeredAdapter
        }
    }

    private fun openNavigationMenu() = with(binding) {
        navManu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    override fun setupListener() {
        addNote()
        openNavigationMenu()
        changeLayoutManager()
        searchNote()
    }

    override fun setupSubscribes() {
        viewModel.loadAllNote().observe(viewLifecycleOwner) { notes ->
            Log.e("SEARCH_NOTES", notes.toString())
            noteAdapter.submitList(notes)
            noteStaggeredAdapter.submitList(notes)
        }
    }

    override fun addNote() {
        binding.btnAddNote.setOnClickListener {
            navigate(R.id.action_mainFragment_to_addNoteFragment)
        }
    }

    override fun detailNote(id: Int) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToDetailFragment(id)
        )
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
    }

    private fun changeLayoutManager() = with(binding) {
        changeLayout.setOnClickListener {
            if (recyclerViewLinear.visibility == View.VISIBLE) {
                recyclerViewLinear.visibility = View.GONE
                recyclerViewStaggeredGrid.visibility = View.VISIBLE
                changeLayout.setBackgroundResource(R.drawable.ic_linear_layout)
                viewModel.changeLinearState(false)
            } else {
                recyclerViewLinear.visibility = View.VISIBLE
                recyclerViewStaggeredGrid.visibility = View.GONE
                changeLayout.setBackgroundResource(R.drawable.ic_grid_layout)
                viewModel.changeLinearState(true)
            }
        }
    }

    private fun searchNote() {
        binding.etSearchForNotes.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                viewModel.loadAllNote().observe(viewLifecycleOwner) { notes ->
                    noteAdapter.submitList(notes)
                    noteStaggeredAdapter.submitList(notes)
                }
            } else {
                viewModel.searchNote("%$it%").observe(viewLifecycleOwner) { notes ->
                    Log.e("SEARCH_NOTES", notes.toString())
                    noteAdapter.submitList(notes)
                    noteStaggeredAdapter.submitList(notes)
                }
            }
        }
    }
}
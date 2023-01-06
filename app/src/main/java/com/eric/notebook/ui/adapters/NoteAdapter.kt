package com.eric.notebook.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eric.notebook.databinding.ItemNoteBinding
import com.eric.notebook.models.NoteModel

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private var noteList: List<NoteModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {

        noteList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: NoteModel) = with(binding) {

            val dataAndTime = "${model.date}\n${model.time}"

            itemBackground.setBackgroundColor(Color.parseColor(model.backgroundColor))
            itemDescription.text = model.description
            itemTitle.text = model.title
            itemDataAndTime.text = dataAndTime
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(noteList[position])
    }

    override fun getItemCount(): Int = noteList.size

}
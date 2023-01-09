package com.eric.notebook.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eric.notebook.base.BaseDiffUtilItemCallBack
import com.eric.notebook.databinding.ItemNoteBinding
import com.eric.notebook.models.NoteModel

interface ClicksAdapter<T> {

    fun onBind(model: T)

    fun shortClick()

    fun longClick()
}

class NoteAdapter(
    private val shortClick: (id: Int) -> Unit,
    private val longClick: (noteModel: NoteModel) -> Unit
) : ListAdapter<NoteModel, NoteAdapter.ViewHolder>(BaseDiffUtilItemCallBack.Base()) {

    inner class ViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root), ClicksAdapter<NoteModel> {

        override fun onBind(model: NoteModel) = with(binding) {
            val dataAndTime = "${model.date}\n${model.time}"
            itemTitle.text = model.title
            itemDataAndTime.text = dataAndTime
            itemDescription.text = model.description
            itemBackground.setBackgroundColor(Color.parseColor(model.backgroundColor))

            shortClick()
            longClick()
        }

        override fun shortClick() {
            itemView.setOnClickListener {
                shortClick(getItem(absoluteAdapterPosition).id)
            }
        }

        override fun longClick() {
            itemView.setOnLongClickListener {
                longClick(getItem(absoluteAdapterPosition))
                return@setOnLongClickListener true
            }
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
        holder.onBind(getItem(position))
    }
}
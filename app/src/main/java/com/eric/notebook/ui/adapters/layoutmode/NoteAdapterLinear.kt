package com.eric.notebook.ui.adapters.layoutmode

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eric.notebook.R
import com.eric.notebook.base.BaseDiffUtilItemCallBack
import com.eric.notebook.databinding.ItemNoteLinearBinding
import com.eric.notebook.models.NoteModel

interface ClicksAdapter<T> {

    fun onBind(model: T)

    fun shortClick()

    fun longClick()
}

class NoteAdapter(
    private val shortClick: (id: Int) -> Unit,
    private val longClick: (noteModel: NoteModel) -> Unit,
) : ListAdapter<NoteModel, NoteAdapter.ViewHolder>(BaseDiffUtilItemCallBack.Base()) {

    private var context: Context? = null

    // it is necessary to convey the context
    fun setContext(context: Context) {
        this.context = context
    }

    inner class ViewHolder(private val binding: ItemNoteLinearBinding) :
        RecyclerView.ViewHolder(binding.root), ClicksAdapter<NoteModel> {

        override fun onBind(model: NoteModel) = with(binding) {
            val dataAndTime = "${model.date}\n${model.time}"
            itemTitle.text = model.title
            itemDataAndTime.text = dataAndTime
            itemDescription.text = model.description
            itemBackground.setBackgroundColor(Color.parseColor(model.backgroundColor))

            when (model.backgroundColor) {
                "#191818" -> {
                    itemTitle.setTextColor(context!!.getColor(R.color.white))
                    itemDataAndTime.setTextColor(context!!.getColor(R.color.white))
                    itemDescription.setTextColor(context!!.getColor(R.color.white))
                }

                "#EBE4C9" -> {
                    itemTitle.setTextColor(context!!.getColor(R.color.milk))
                    itemDataAndTime.setTextColor(context!!.getColor(R.color.milk))
                    itemDescription.setTextColor(context!!.getColor(R.color.milk))
                }

                else -> {
                    itemTitle.setTextColor(context!!.getColor(R.color.orange))
                    itemDataAndTime.setTextColor(context!!.getColor(R.color.orange))
                    itemDescription.setTextColor(context!!.getColor(R.color.orange))
                }
            }

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
            ItemNoteLinearBinding.inflate(
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
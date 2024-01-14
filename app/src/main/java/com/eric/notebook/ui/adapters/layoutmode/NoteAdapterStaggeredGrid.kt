package com.eric.notebook.ui.adapters.layoutmode

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eric.notebook.R
import com.eric.notebook.base.BaseDiffUtilItemCallBack
import com.eric.notebook.databinding.ItemNoteStaggeredBinding
import com.eric.notebook.models.NoteModel

class NoteAdapterStaggeredGrid(
    private val shortClickSG: (id: Int) -> Unit,
    private val longClickSG: (model: NoteModel) -> Unit
) :
    ListAdapter<NoteModel, NoteAdapterStaggeredGrid.ViewHolder>(BaseDiffUtilItemCallBack.Base()) {

    private var context: Context? = null

    // it is necessary to convey the context
    fun setContext(context: Context) {
        this.context = context
    }

    inner class ViewHolder(private val binding: ItemNoteStaggeredBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: NoteModel) = with(binding) {
            val dataAndTime = "${model.date} ${model.time}"
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

        private fun shortClick() {
            itemView.setOnClickListener {
                shortClickSG(getItem(absoluteAdapterPosition).id)
            }
        }

        private fun longClick() {
            itemView.setOnLongClickListener {
                longClickSG(getItem(absoluteAdapterPosition))
                return@setOnLongClickListener true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNoteStaggeredBinding.inflate(
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
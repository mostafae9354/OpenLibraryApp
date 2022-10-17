package com.moessa.openLibrary.module.docs_list.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.moessa.openLibrary.R
import com.moessa.openLibrary.module.docs_list.presentation.uimodel.DocUiModel

class DocsAdapter : ListAdapter<DocUiModel, DocsAdapter.DataViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<DocUiModel>() {
        override fun areItemsTheSame(oldItem: DocUiModel, newItem: DocUiModel): Boolean {
            return oldItem.cover == newItem.cover
        }

        override fun areContentsTheSame(oldItem: DocUiModel, newItem: DocUiModel): Boolean {
            return oldItem.title == newItem.title
        }
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvDocTitle: AppCompatTextView = itemView.findViewById(R.id.tv_doc_title)
        private val tvDocAuthorName: AppCompatTextView = itemView.findViewById(R.id.tv_author_name)

        fun bind(docUiModel: DocUiModel) {
            tvDocTitle.text = docUiModel.title
            tvDocAuthorName.text = docUiModel.authorName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_repo, parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(getItem(position))
}
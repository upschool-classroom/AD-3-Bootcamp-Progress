package com.canerture.week9.ui.notes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.canerture.week9.data.model.Note
import com.canerture.week9.databinding.ItemNoteBinding

class NotesAdapter(
    private val onNoteClick: (Note) -> Unit,
    private val onDeleteClick: (String) -> Unit
) : ListAdapter<Note, NotesAdapter.NoteViewHolder>(NoteDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder =
        NoteViewHolder(
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onNoteClick,
            onDeleteClick
        )

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(getItem(position))

    class NoteViewHolder(
        private val binding: ItemNoteBinding,
        private val onNoteClick: (Note) -> Unit,
        private val onDeleteClick: (String) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(note: Note) = with(binding) {
            tvTitle.text = note.title
            tvDesc.text = note.description

            root.setOnClickListener {
                onNoteClick(note)
            }

            ivDelete.setOnClickListener {
                note.documentId?.let(onDeleteClick)
            }
        }
    }

    class NoteDiffCallBack : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.documentId == newItem.documentId
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }
    }
}
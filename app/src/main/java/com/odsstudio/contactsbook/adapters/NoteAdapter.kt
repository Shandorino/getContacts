package com.odsstudio.contactsbook.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odsstudio.contactsbook.data.model.Note
import com.odsstudio.contactsbook.databinding.NoteViewHolderBinding

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val items: MutableList<Note>  = mutableListOf()



    inner class NoteViewHolder(private val binding: NoteViewHolderBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun onBind(note: Note) {
            with(binding) {
                noteTitle.text = note.title
                noteBody.text = note.body
            }
        }
    }

    fun setList(list: List<Note>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NoteViewHolderBinding.inflate(inflater, parent, false)

        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       val item = items[position]

        holder.onBind(note = item)
    }

    override fun getItemCount(): Int = items.size
}
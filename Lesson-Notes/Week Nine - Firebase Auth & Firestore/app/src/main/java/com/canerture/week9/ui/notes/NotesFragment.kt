package com.canerture.week9.ui.notes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.canerture.week9.R
import com.canerture.week9.common.viewBinding
import com.canerture.week9.data.model.Note
import com.canerture.week9.databinding.FragmentNotesBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created on 17.08.2023
 * @author Caner Türe
 */

class NotesFragment : Fragment(R.layout.fragment_notes) {

    private val binding by viewBinding(FragmentNotesBinding::bind)

    private val notesAdapter by lazy { NotesAdapter(::onNoteClick, ::onDeleteClick) }

    private lateinit var db: FirebaseFirestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = Firebase.firestore

        with(binding) {
            rvNotes.adapter = notesAdapter

            fabAdd.setOnClickListener {
                findNavController().navigate(R.id.notesToNoteDetail)
            }
        }

        listenNotes()
    }

    private fun listenNotes() {

        db.collection("notes").addSnapshotListener { snapshot, e ->

            val tempList = arrayListOf<Note>()

            snapshot?.forEach { document ->
                tempList.add(
                    Note(
                        document.id,
                        document.get("title") as String,
                        document.get("description") as String,
                    )
                )
            }

            notesAdapter.submitList(tempList)
        }
    }

    private fun deleteNote(docId: String) {
        db.collection("notes").document(docId)
            .delete()
            .addOnSuccessListener {
                //
            }
            .addOnFailureListener {
                //
            }
    }

    private fun onNoteClick(note: Note) {
        val action = NotesFragmentDirections.notesToNoteDetail().setNote(note)
        findNavController().navigate(action)
    }

    private fun onDeleteClick(docId: String) {
        deleteNote(docId)
    }
}
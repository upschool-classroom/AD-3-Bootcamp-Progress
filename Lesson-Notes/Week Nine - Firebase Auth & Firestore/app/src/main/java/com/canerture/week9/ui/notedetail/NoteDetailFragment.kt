package com.canerture.week9.ui.notedetail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.canerture.week9.R
import com.canerture.week9.common.viewBinding
import com.canerture.week9.data.model.Note
import com.canerture.week9.databinding.FragmentNoteDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created on 17.08.2023
 * @author Caner Türe
 */

class NoteDetailFragment : BottomSheetDialogFragment(R.layout.fragment_note_detail) {

    private val binding by viewBinding(FragmentNoteDetailBinding::bind)

    private val args by navArgs<NoteDetailFragmentArgs>()

    private lateinit var db: FirebaseFirestore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = Firebase.firestore

        with(binding) {
            args.note?.let {
                etTitle.setText(it.title)
                etDesc.setText(it.description)
                btnSave.visibility = View.VISIBLE
                btnAdd.visibility = View.GONE
            }

            btnAdd.setOnClickListener {
                val title = etTitle.text.toString()
                val desc = etDesc.text.toString()

                if (title.isNotEmpty() && desc.isNotEmpty()) {
                    addNote(title, desc)
                } else {
                    //
                }
            }

            btnSave.setOnClickListener {
                val title = etTitle.text.toString()
                val desc = etDesc.text.toString()

                if (title.isNotEmpty() && desc.isNotEmpty()) {
                    saveNote(args.note?.documentId ?: "", title, desc)
                } else {
                    //
                }
            }
        }
    }

    private fun addNote(title: String, desc: String) {
        val note = Note(
            documentId = null,
            title = title,
            description = desc
        )
        db.collection("notes").document(title).set(note).addOnSuccessListener {
            findNavController().navigateUp()
        }.addOnFailureListener {
            //
        }
    }

    private fun saveNote(docId: String, title: String, desc: String) {
        db.collection("notes").document(docId)
            .update(
                mapOf(
                    "title" to title,
                    "description" to desc
                )
            )
            .addOnSuccessListener {
                findNavController().navigateUp()
            }
            .addOnFailureListener {
                //
            }
    }
}
package com.example.santiagovazquez.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ClubViewModel: ViewModel() {
    private val db = Firebase.firestore
    private val clubcollection = db.collection("")
    private val _uiState = MutableStateFlow<List<ClubUiState>>(emptyList())
    val uiState: StateFlow<List<ClubUiState>> = _uiState

    init {
        getJugadores()
    }
    private fun getJugadores() {
        clubcollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                return@addSnapshotListener
            }

            if (snapshot != null) {
                val jugadoresList = snapshot.documents.mapNotNull { doc ->
                    val jugador = doc.toObject(ClubUiState::class.java)
                    jugador?.id = doc.id
                    jugador
                }
                _uiState.value = jugadoresList
            }
        }

    }


}
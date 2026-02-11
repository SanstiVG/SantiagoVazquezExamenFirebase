package com.example.santiagovazquez.viewmodel

import kotlinx.serialization.Serializable

@Serializable
data class ClubUiState(
    var id: String = "",
    val nombre: String = "",
    val numero: Int = 0,
    val nacionalidad: String = "",
    val posicion: String = "",
    val imagen: String = "",

    )
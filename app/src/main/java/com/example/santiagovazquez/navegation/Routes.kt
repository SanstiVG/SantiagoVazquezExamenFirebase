package com.example.santiagovazquez.navegation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes: NavKey {
    @Serializable
    data object Login: Routes()
    @Serializable
    data class Home(val id: String): Routes()
    @Serializable
    data class NuevoJugador(val id: String): Routes()

    @Serializable
    data object Error: Routes()
}
package com.example.santiagovazquez.navegation

import androidx.navigation3.runtime.NavKey

sealed class Routes: NavKey {
    @Serializable
    data object Login: Routes()
    @Serializable
    data class Home(val id: String): Routes()
}
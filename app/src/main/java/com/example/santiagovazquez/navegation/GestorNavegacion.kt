package com.example.santiagovazquez.navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.google.firebase.auth.FirebaseAuth

@Composable
fun GestorNavegacion(auth: FirebaseAuth,modifier: Modifier) {
    val pilaNavegacion = rememberNavBackStack(Routes.Login)
    NavDisplay(
        backStack = pilaNavegacion,
        onBack = {pilaNavegacion.removeLastOrNull()},
        entryProvider = { key ->
            when (key) {

            }
        }
}
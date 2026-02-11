package com.example.santiagovazquez.navegation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.santiagovazquez.view.PantallaHome
import com.example.santiagovazquez.view.PantallaLogin
import com.example.santiagovazquez.view.PantallaNuevoJugador
import com.google.firebase.auth.FirebaseAuth

@Composable
fun GestorNavegacion(auth: FirebaseAuth) {
    val pilaNavegacion = rememberNavBackStack(Routes.Login)
    NavDisplay(
        backStack = pilaNavegacion,
        onBack = {pilaNavegacion.removeLastOrNull()},
        entryProvider = { key ->
            when (key) {
                is Routes.Login -> NavEntry(key) {
                    PantallaLogin(auth = auth, navegaHome = {
                        pilaNavegacion.add(Routes.Home("id"))
                    })
                }
                is Routes.Home -> NavEntry(key) {
                    PantallaHome(
                        navegaNuevoJugador = {pilaNavegacion.add(Routes.NuevoJugador("id"))}
                    )
                }
                is Routes.NuevoJugador -> NavEntry(key) {
                    PantallaNuevoJugador(
                        navegaAtras = { pilaNavegacion.removeLastOrNull() }
                    )
                }

                else -> null
            }!!
        }
    )
}
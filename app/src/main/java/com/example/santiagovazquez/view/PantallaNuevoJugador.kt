package com.example.santiagovazquez.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.santiagovazquez.viewmodel.ClubViewModel

@Composable
fun PantallaNuevoJugador(viewModel: ClubViewModel = viewModel(),navegaAtras: () -> Unit) {
    var nombre by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var posicion by remember { mutableStateOf("") }
    var nacionalidad by remember { mutableStateOf("") }
    var imagen by remember { mutableStateOf("") }
    Scaffold {
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Text("Nuevo Jugador",fontWeight = FontWeight.Bold,
                fontSize = 24.sp, modifier = Modifier.padding(16.dp))
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text(text = "Nombre") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
            )
            OutlinedTextField(
                value = numero,
                onValueChange = { numero = it },
                label = { Text(text = "Número") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
            )
            OutlinedTextField(
                value = posicion,
                onValueChange = { posicion = it },
                label = { Text(text = "Posición") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
            )
            OutlinedTextField(
                value = nacionalidad,
                onValueChange = { nacionalidad = it },
                label = { Text(text = "Nacionalidad") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
            )
            OutlinedTextField(
                value = imagen,
                onValueChange = { imagen = it },
                label = { Text(text = "URL imagen") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
            )

            Row(modifier = Modifier.padding(16.dp)) {
                Button(
                    onClick = {
                        viewModel.addJugador(nombre, numero.toInt(), nacionalidad, posicion, imagen)
                        navegaAtras()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF27D21F)
                    )

                ) {
                    Text("Agragar Jugador")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = {navegaAtras()},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF27D21F)
                    )
                ) {
                    Text("Cancelar")
                }
            }
        }
    }

}
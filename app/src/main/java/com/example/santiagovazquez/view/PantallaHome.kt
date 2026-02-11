package com.example.santiagovazquez.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.santiagovazquez.viewmodel.ClubUiState
import com.example.santiagovazquez.viewmodel.ClubViewModel

@Composable
fun PantallaHome(viewModel: ClubViewModel = viewModel(), navegaNuevoJugador: () -> Unit) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold {
        paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Plantilla temporada 25/26", fontWeight = FontWeight.Bold,
                fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(uiState) {
                    jugador ->
                    JugadorItem(jugador = jugador, onBorrar = {
                        viewModel.deleteJugador(jugador.id)
                    })

                }

            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                onClick = { navegaNuevoJugador()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF27D21F)
                )
            ){
                Text("Agregar Jugador")
            }

        }
    }

}
@Composable
fun JugadorItem(jugador: ClubUiState, onBorrar: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            Color(0xFFF2FCEE)
        )
    ) {
        Column (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = jugador.imagen,
                contentDescription = "",
                modifier = Modifier.size(128.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.padding(end = 4.dp),
                    shape = RoundedCornerShape(34.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF27D21F)
                    )
                ) {
                    Text(jugador.numero.toString())
                }
                Spacer(modifier = Modifier.weight(1f))
                Column() {
                    Text(
                        text = jugador.nombre,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Text(
                        text = jugador.nacionalidad,
                        fontSize = 12.sp
                    )
                    Text(
                        text = jugador.posicion,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = onBorrar, modifier = Modifier.padding(start = 4.dp)) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "",
                        tint = Color.Red
                    )
                }
            }
        }

    }
}


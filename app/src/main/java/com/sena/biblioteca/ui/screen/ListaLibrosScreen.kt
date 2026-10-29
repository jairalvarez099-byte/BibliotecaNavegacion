package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca.ui.componentes.BarraSuperior
import com.sena.biblioteca.ui.componentes.PortadaLibro
import com.sena.biblioteca.ui.componentes.Tarjeta
import com.sena.biblioteca.ui.theme.Fondo
import com.sena.biblioteca.ui.theme.GrisTexto

// PANTALLA 2 (Parte 1): Lista de libros
@Composable
fun ListaLibrosScreen(
    onVerDetalle: (String) -> Unit,   // recibe el nombre del libro elegido
    onVolver: () -> Unit,
) {
    // Datos estáticos: los nombres de los libros
    val libros = listOf(
        "Clean Code",
        "Kotlin para Android",
        "Arquitectura de Software",
        "Jetpack Compose",
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(16.dp)
    ) {
        BarraSuperior(titulo = "📖 Mis Libros", onVolver = onVolver)
        Text(text = "Elige un libro para ver más detalles.", color = GrisTexto)

        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn = lista con scroll. Dibuja una tarjeta por cada libro
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(libros) { libro ->
                Tarjeta {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        PortadaLibro(nombreLibro = libro, tamano = 44)
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = libro,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                        // Aquí se ENVÍA el parámetro: el nombre del libro
                        OutlinedButton(onClick = { onVerDetalle(libro) }) {
                            Text(text = "Ver Detalle")
                        }
                    }
                }
            }
        }
    }
}

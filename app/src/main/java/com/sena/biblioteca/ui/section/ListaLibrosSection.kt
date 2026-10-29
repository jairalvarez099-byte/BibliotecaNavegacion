package com.sena.biblioteca.ui.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.sena.biblioteca.ui.componentes.PortadaLibro
import com.sena.biblioteca.ui.componentes.Tarjeta

// Lista con scroll: una tarjeta con portada, nombre y botón por cada libro
@Composable
fun ListaLibrosSection(
    onVerDetalle: (String) -> Unit,   // avisa qué libro se eligió
) {
    // Datos estáticos: los nombres de los libros
    val libros = listOf(
        "Clean Code",
        "Kotlin para Android",
        "Arquitectura de Software",
        "Jetpack Compose",
    )

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

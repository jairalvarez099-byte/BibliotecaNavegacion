package com.sena.biblioteca.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.biblioteca.ui.componentes.BarraSuperior
import com.sena.biblioteca.ui.section.ListaLibrosSection
import com.sena.biblioteca.ui.theme.Fondo
import com.sena.biblioteca.ui.theme.GrisTexto

// PANTALLA 2 (Parte 1): Lista de libros
@Composable
fun ListaLibrosScreen(
    onVerDetalle: (String) -> Unit,   // recibe el nombre del libro elegido
    onVolver: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Fondo)
            .padding(16.dp)
    ) {
        BarraSuperior(titulo = "📖 Mis Libros", onVolver = onVolver)
        Text(text = "Elige un libro para ver más detalles.", color = GrisTexto)

        Spacer(modifier = Modifier.height(16.dp))

        // La section avisa qué libro se eligió y se lo pasamos a onVerDetalle
        ListaLibrosSection(onVerDetalle = onVerDetalle)
    }
}

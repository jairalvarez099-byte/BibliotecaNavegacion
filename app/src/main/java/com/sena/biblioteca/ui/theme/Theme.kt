package com.sena.biblioteca.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colores de la app (los mismos de la imagen de la práctica)
val Morado = Color(0xFF4F3CC9)
val Verde = Color(0xFF2E9E4F)
val Naranja = Color(0xFFF08A24)
val Rojo = Color(0xFFE53935)
val Fondo = Color(0xFFF6F5FF)
val GrisTexto = Color(0xFF6B6B7B)

@Composable
fun BibliotecaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Morado,
            secondary = Verde,
            background = Fondo,
            surface = Color.White,
        ),
        content = content
    )
}

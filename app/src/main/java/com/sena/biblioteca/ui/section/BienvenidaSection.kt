package com.sena.biblioteca.ui.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca.ui.theme.GrisTexto
import com.sena.biblioteca.ui.theme.Morado

// Círculo con el ícono de la biblioteca, título de bienvenida y subtítulo
@Composable
fun BienvenidaSection() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(180.dp)
                .background(Morado.copy(alpha = 0.12f), CircleShape)
        ) {
            Text(text = "🏛️", fontSize = 90.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "¡Bienvenido a tu Biblioteca!",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Descubre, aprende y reserva tus libros favoritos.",
            color = GrisTexto,
            textAlign = TextAlign.Center
        )
    }
}

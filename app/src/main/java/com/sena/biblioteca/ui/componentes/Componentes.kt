package com.sena.biblioteca.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.biblioteca.ui.theme.GrisTexto

// Piezas pequeñas que se repiten en varias pantallas.
// Así no copiamos el mismo código muchas veces.

// Botón grande de color con texto
@Composable
fun BotonGrande(
    texto: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
    ) {
        Text(text = texto, fontSize = 16.sp)
    }
}

// Barra superior con flecha de regreso y título
@Composable
fun BarraSuperior(
    titulo: String,
    onVolver: () -> Unit,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        TextButton(onClick = onVolver) {
            Text(text = "←", fontSize = 22.sp)
        }
        Text(text = titulo, fontSize = 22.sp, fontWeight = FontWeight.Bold)
    }
}

// Tarjeta blanca con bordes redondeados
@Composable
fun Tarjeta(
    modifier: Modifier = Modifier,
    contenido: @Composable () -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            contenido()
        }
    }
}

// Una fila "Etiqueta: valor"
@Composable
fun DatoFila(etiqueta: String, valor: String, colorValor: Color = Color.Black) {
    Row(modifier = Modifier.padding(vertical = 4.dp)) {
        Text(text = etiqueta, color = GrisTexto, modifier = Modifier.width(130.dp))
        Text(text = valor, color = colorValor, fontWeight = FontWeight.Medium)
    }
}

// Portada del libro: un cuadro de color con el ícono y el nombre
@Composable
fun PortadaLibro(nombreLibro: String, tamano: Int) {
    // Según el nombre del libro escogemos ícono y color (datos estáticos)
    val icono = when (nombreLibro) {
        "Clean Code" -> "📘"
        "Kotlin para Android" -> "🤖"
        "Arquitectura de Software" -> "🧩"
        else -> "🎨"
    }
    val color = when (nombreLibro) {
        "Clean Code" -> Color(0xFF1E2A4A)
        "Kotlin para Android" -> Color(0xFF3DDC84)
        "Arquitectura de Software" -> Color(0xFFF57C00)
        else -> Color(0xFF00897B)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(width = tamano.dp, height = (tamano * 1.4).dp)
            .background(color, RoundedCornerShape(8.dp))
            .padding(6.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = icono, fontSize = (tamano / 3).sp)
            if (tamano >= 100) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = nombreLibro,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}

// Etiqueta pequeña de estado: "Activa" (verde) o "Cancelada" (roja)
@Composable
fun EtiquetaEstado(estado: String, color: Color) {
    Text(
        text = estado,
        color = color,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .background(color.copy(alpha = 0.12f), RoundedCornerShape(50))
            .padding(horizontal = 14.dp, vertical = 4.dp)
    )
}

package com.sena.biblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sena.biblioteca.navegacion.AppNavegacion
import com.sena.biblioteca.ui.theme.BibliotecaTheme

// Punto de entrada de la app: lo primero que abre Android
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BibliotecaTheme {
                // Scaffold da el espacio de la pantalla; innerPadding evita que
                // el contenido quede debajo de la barra de estado
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavegacion(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

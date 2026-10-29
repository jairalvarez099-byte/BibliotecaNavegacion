package com.sena.biblioteca.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sena.biblioteca.ui.screen.ConfirmacionScreen
import com.sena.biblioteca.ui.screen.DetalleLibroScreen
import com.sena.biblioteca.ui.screen.DetalleReservaScreen
import com.sena.biblioteca.ui.screen.InicioScreen
import com.sena.biblioteca.ui.screen.ListaLibrosScreen
import com.sena.biblioteca.ui.screen.MisReservasScreen
import com.sena.biblioteca.ui.screen.RenovacionExitosaScreen
import com.sena.biblioteca.ui.screen.RenovarReservaScreen

@Composable
fun AppNavegacion(modifier: Modifier = Modifier) {
    // NavController: el "control remoto" que nos mueve entre pantallas
    val navController = rememberNavController()

    // NavHost: el "contenedor" donde se muestra la pantalla actual
    NavHost(
        navController = navController,
        startDestination = Inicio,   // primera pantalla al abrir la app
        modifier = modifier
    ) {

        // ================= PARTE 1: BIBLIOTECA =================

        composable<Inicio> {
            InicioScreen(
                onVerLibros = {
                    navController.navigate(ListaLibros)
                }
            )
        }

        composable<ListaLibros> {
            ListaLibrosScreen(
                onVerDetalle = { nombre ->
                    // ENVIAR parámetro: creamos la ruta con el nombre del libro
                    navController.navigate(DetalleLibro(nombreLibro = nombre))
                },
                onVolver = {
                    navController.popBackStack()
                }
            )
        }

        composable<DetalleLibro> { backStackEntry ->
            // RECIBIR parámetro: toRoute convierte la ruta en el objeto con sus datos
            val datos = backStackEntry.toRoute<DetalleLibro>()
            DetalleLibroScreen(
                nombreLibro = datos.nombreLibro,
                onReservar = { nombre ->
                    navController.navigate(
                        Confirmacion(nombreLibro = nombre, fechaReserva = "15/06/2026")
                    )
                },
                onVolver = {
                    navController.popBackStack()
                }
            )
        }

        composable<Confirmacion> { backStackEntry ->
            val datos = backStackEntry.toRoute<Confirmacion>()
            ConfirmacionScreen(
                nombreLibro = datos.nombreLibro,
                fechaReserva = datos.fechaReserva,
                onVolverInicio = {
                    // Regresa a Inicio y borra del historial las pantallas intermedias
                    navController.popBackStack(Inicio, inclusive = false)
                },
                onVerMisReservas = {
                    // Puente a la Parte 2: pasamos los datos de la reserva
                    navController.navigate(
                        MisReservas(
                            nombreLibro = datos.nombreLibro,
                            fechaReserva = datos.fechaReserva,
                            estado = "Activa"
                        )
                    )
                }
            )
        }

        // ================= PARTE 2: MIS RESERVAS =================

        composable<MisReservas> { backStackEntry ->
            val datos = backStackEntry.toRoute<MisReservas>()
            MisReservasScreen(
                nombreLibro = datos.nombreLibro,
                fechaReserva = datos.fechaReserva,
                estado = datos.estado,
                onVerReserva = {
                    // Enviamos 3 parámetros a la vez
                    navController.navigate(
                        DetalleReserva(
                            nombreLibro = datos.nombreLibro,
                            fechaReserva = datos.fechaReserva,
                            codigoReserva = "RES-2026-001"
                        )
                    )
                },
                onVolver = {
                    navController.popBackStack(Inicio, inclusive = false)
                }
            )
        }

        composable<DetalleReserva> { backStackEntry ->
            val datos = backStackEntry.toRoute<DetalleReserva>()
            DetalleReservaScreen(
                nombreLibro = datos.nombreLibro,
                fechaReserva = datos.fechaReserva,
                codigoReserva = datos.codigoReserva,
                onRenovar = {
                    navController.navigate(
                        RenovarReserva(
                            nombreLibro = datos.nombreLibro,
                            fechaReserva = datos.fechaReserva
                        )
                    )
                },
                onCancelar = {
                    // Volvemos a Mis Reservas con estado "Cancelada".
                    // popUpTo<Inicio> borra el historial hasta Inicio para no
                    // poder regresar con la flecha a una reserva ya cancelada.
                    navController.navigate(
                        MisReservas(
                            nombreLibro = datos.nombreLibro,
                            fechaReserva = datos.fechaReserva,
                            estado = "Cancelada"
                        )
                    ) {
                        popUpTo<Inicio>()
                    }
                },
                onVolver = {
                    navController.popBackStack()
                }
            )
        }

        composable<RenovarReserva> { backStackEntry ->
            val datos = backStackEntry.toRoute<RenovarReserva>()
            RenovarReservaScreen(
                nombreLibro = datos.nombreLibro,
                fechaReserva = datos.fechaReserva,
                onConfirmar = { fechaNueva ->
                    navController.navigate(
                        RenovacionExitosa(nombreLibro = datos.nombreLibro, fechaNueva = fechaNueva)
                    )
                },
                onVolver = {
                    navController.popBackStack()
                }
            )
        }

        composable<RenovacionExitosa> { backStackEntry ->
            val datos = backStackEntry.toRoute<RenovacionExitosa>()
            RenovacionExitosaScreen(
                nombreLibro = datos.nombreLibro,
                fechaNueva = datos.fechaNueva,
                onVolverMisReservas = {
                    // Mis Reservas ahora muestra la fecha nueva
                    navController.navigate(
                        MisReservas(
                            nombreLibro = datos.nombreLibro,
                            fechaReserva = datos.fechaNueva,
                            estado = "Activa"
                        )
                    ) {
                        popUpTo<Inicio>()
                    }
                }
            )
        }
    }
}

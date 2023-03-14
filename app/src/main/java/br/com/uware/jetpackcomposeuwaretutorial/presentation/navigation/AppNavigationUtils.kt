package br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation

import androidx.navigation.NavHostController

/**
 * popUpTo
 *
 * Função que navega para próxima tela removendo a anterior do navBackStackEntry(Botão de voltar)
 *
 * @param route String do nome da rota.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose
 */
fun NavHostController.popUpTo(route: String) {
    val currentRoute = this.currentDestination?.route
    this.navigate(route) {
        popUpTo(currentRoute.toString()) {
            inclusive = true
        }
    }
}
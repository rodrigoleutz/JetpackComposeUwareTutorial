package br.com.uware.jetpackcomposeuwaretutorial.presentation.core

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

/**
 * MainApp
 *
 * Classe centro do app que carrega informações utilizadas.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose(navHostController, currentDestination, currentRoute)
 * @version 1.0.1 - 2023 03 18 - Top App Bar no Jetpack Compose(Adição do viewModel)
 */
class MainApp(
    val navHostController: NavHostController,
    val currentDestination: State<NavBackStackEntry?>,
    val viewModel: MainViewModel
) {
    val currentRoute = currentDestination.value?.destination?.route.toString()
}

/**
 * rememberMainApp
 *
 * Função do compose que relembra o estado das variáveis da classe MainApp.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose
 * @version 1.0.1 - 2023 03 18 - Top App Bar no Jetpack Compose(Adição do viewModel)
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun rememberMainApp(
    navHostController: NavHostController = rememberAnimatedNavController(),
    currentDestination: State<NavBackStackEntry?> = navHostController.currentBackStackEntryAsState(),
    viewModel: MainViewModel = hiltViewModel()
): MainApp {
    return MainApp(
        navHostController = navHostController,
        currentDestination = currentDestination,
        viewModel = viewModel
    )
}
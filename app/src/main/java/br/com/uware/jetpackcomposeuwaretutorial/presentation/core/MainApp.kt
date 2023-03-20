package br.com.uware.jetpackcomposeuwaretutorial.presentation.core

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
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
 * @version 1.0.2 - 2023 03 18 - Navigation Drawer no Jetpack Compose(Adição do drawerState)
 * @version 1.0.0 - 2023 03 19 - Loading no Jetpack Compose(Adição do snackbarHost)
 */
class MainApp(
    val navHostController: NavHostController,
    val currentDestination: State<NavBackStackEntry?>,
    val viewModel: MainViewModel,
    val drawerState: DrawerState,
    val snackbarHostState: SnackbarHostState
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
 * @version 1.0.2 - 2023 03 18 - Navigation Drawer no Jetpack Compose(Adição do drawerState)
 * @version 1.0.0 - 2023 03 19 - Loading no Jetpack Compose(Adição do snackbarHost)
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun rememberMainApp(
    navHostController: NavHostController = rememberAnimatedNavController(),
    currentDestination: State<NavBackStackEntry?> = navHostController.currentBackStackEntryAsState(),
    viewModel: MainViewModel = hiltViewModel(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    snackbarHostState: SnackbarHostState = remember { SnackbarHostState() }
): MainApp {
    return MainApp(
        navHostController = navHostController,
        currentDestination = currentDestination,
        viewModel = viewModel,
        drawerState = drawerState,
        snackbarHostState = snackbarHostState
    )
}
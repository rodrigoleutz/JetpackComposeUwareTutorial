package br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.home.HomeScreen
import br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.name.NameScreen
import br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.splash.SplashScreen

/**
 * AppNavigation
 *
 * Função que controla a navegação do aplicativo através do navHostController.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose(HomeScreen, NameScreen, SplashScreen)
 */
@Composable
fun AppNavigation(mainApp: MainApp) {
    NavHost(
        navController = mainApp.navHostController,
        startDestination = AppScreens.SplashScreen.name
    ) {
        composable(AppScreens.HomeScreen.name) {
            HomeScreen(mainApp = mainApp)
        }
        /**
         * Rota NameScreen recebendo o argumento name.
         */
        composable(
            AppScreens.NameScreen.name + "?name={name}",
            listOf(navArgument("name") {
                type = NavType.StringType
            })
        ) {navBackStackEntry ->
            /**
             * Pegando o argumento name na navBackStackEntry.
             */
            val name = navBackStackEntry.arguments?.getString("name").toString()
            NameScreen(mainApp = mainApp, name = name)
        }
        composable(AppScreens.SplashScreen.name) {
            SplashScreen(mainApp = mainApp)
        }
    }
}
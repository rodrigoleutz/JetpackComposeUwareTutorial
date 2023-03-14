package br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation.AppScreens
import br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation.popUpTo
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions
import kotlinx.coroutines.delay

/**
 * SplashScreen
 *
 * Tela de splash do app.
 *
 * @param mainApp Classe MainApp criada no começo com rememberMainApp.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose
 */
@Composable
fun SplashScreen(
    mainApp: MainApp
) {
    LaunchedEffect(key1 = true, block = {
        delay(2000)
        /**
         * Navega para HomeScreen removendo SplashScreen da navBackStackEntry.
         */
        mainApp.navHostController.popUpTo(AppScreens.HomeScreen.name)
    })
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimensions.LARGE),
            painter = painterResource(id = R.drawable.uware),
            contentDescription = stringResource(id = R.string.uware_logo)
        )
        Text(text = stringResource(id = R.string.splash_screen))
    }
}
package br.com.uware.jetpackcomposeuwaretutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.rememberMainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation.AppNavigation
import br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.main.MainScreen
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.JetpackComposeUwareTutorialTheme
import dagger.hilt.android.AndroidEntryPoint


/**
 * MainActivity
 *
 * Leva a anotação AndroidEntryPoint, sendo o ponto de partida da applicação.
 * Anotação do Dagger Hilt.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navegação no Jetpack Compose
 * @version 1.0.1 - 2023 03 18 - Top App Bar no Jetpack Compose(Adicionando Dagger Hilt e MainScreen)
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /**
             * Classe MainApp sendo instanciada.
             */
            val mainApp = rememberMainApp()
            MaterialTheme {
                JetpackComposeUwareTutorialTheme {
                    MainScreen(mainApp = mainApp) {
                        AppNavigation(mainApp = mainApp)
                    }
                }
            }
        }
    }
}
package br.com.uware.jetpackcomposeuwaretutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.rememberMainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation.AppNavigation
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.JetpackComposeUwareTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /**
             * Classe MainApp sendo instanciada.
             */
            val mainApp = rememberMainApp()
            JetpackComposeUwareTutorialTheme {
                AppNavigation(mainApp = mainApp)
            }
        }
    }
}
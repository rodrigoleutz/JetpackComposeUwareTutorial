package br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.name


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions

/**
 * NameScreen
 *
 * Tela que recebe um argumento com nome de name.
 *
 * @param mainApp
 * @param name String recebida através da navegação.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose
 */
@Composable
fun NameScreen(
    mainApp: MainApp,
    name: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = name)
        Spacer(modifier = Modifier.height(AppDimensions.LARGE))
        Button(onClick = {
            /**
             * Função de Back Button(Botão Voltar do celular)
             */
            mainApp.navHostController.popBackStack()
        }) {
            Text(text = stringResource(id = R.string.back_button))
        }
    }
}
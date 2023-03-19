package br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.name


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.presentation.components.layouts.column.ColumnCenterComponent
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.Purple40

/**
 * NameScreen
 *
 * Tela que recebe um argumento com nome de name.
 *
 * @param mainApp
 * @param name String recebida através da navegação.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose
 * @version 1.0.2 - 2023 03 18 - Top App Bar no Jetpack Compose
 *                              (Modificando titulo e Cor no LaunchedEffect)
 * @version 1.0.3 - 2023 03 19 - Drawer Menu no Jetpack Compose
 *                              (Adicionado disposableEffect para voltar as cores padrões da topAppBar)
 */
@Composable
fun NameScreen(
    mainApp: MainApp,
    name: String
) {
    LaunchedEffect(key1 = true, block = {
        /**
         * Modificando o título.
         */
        mainApp.viewModel.topBar.setTitle(R.string.name_screen)
        /**
         * Modificando a cor da Top App Bar
         */
        mainApp.viewModel.topBar.setContainerColor(Color.Blue)
        mainApp.viewModel.topBar.setContentColor(Color.Yellow)
    })
    DisposableEffect(key1 = true, effect = {
        onDispose {
            mainApp.viewModel.topBar.setContainerColor(Purple40)
            mainApp.viewModel.topBar.setContentColor(Color.White)
        }
    })
    ColumnCenterComponent {
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
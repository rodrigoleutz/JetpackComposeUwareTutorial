package br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.name

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.presentation.components.layouts.column.ColumnCenterScrollComponent
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation.AppScreens
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions


/**
 * NameInputScreen
 *
 * Tela que envia o nome pelo AppNavigation para a tela NameScreen.
 *
 * @param mainApp Classe MainApp criada no começo com rememberMainApp.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose
 * @version 1.0.1 - 2023 03 14 - Column Layout no Jetpack Compose(Mudança na Column)
 * @version 1.0.2 - 2023 03 18 - Top App Bar no Jetpack Compose(Modificando titulo no LaunchedEffect)
 * @version 1.1.0 - 2023 03 19 - Drawer Menu no Jetpack Compose(Modificado de HomeScreen para NameInputScreen)
 */
@Composable
fun NameInputScreen(
    mainApp: MainApp
) {
    val name = remember {
        mutableStateOf("")
    }
    LaunchedEffect(key1 = true, block = {
        /**
         * Modificando título na Top App Bar
         */
        mainApp.viewModel.topBar.setTitle(R.string.name_screen)
    })
    ColumnCenterScrollComponent {
        Text(text = stringResource(id = R.string.home_screen))
        Spacer(modifier = Modifier.height(AppDimensions.LARGE))
        TextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            label = {
                Text(text = stringResource(id = R.string.name))
            }
        )
        Spacer(modifier = Modifier.height(AppDimensions.LARGE))
        Button(
            onClick = {
                /**
                 * Passando a variável name para a NameScreen
                 * (parecido com páginas na internet utilizando GET)
                 */
                mainApp.navHostController.navigate(
                    AppScreens.NameScreen.name+"?name=${name.value}"
                )
            }
        ) {
            Text(text = stringResource(id = R.string.name_screen))
        }
    }
}
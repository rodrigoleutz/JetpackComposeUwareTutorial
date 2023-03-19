package br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.presentation.components.layouts.column.ColumnCenterScrollComponent
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.menu.AppMenu
import br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.cards.HomeMenuCardWidget
import kotlinx.coroutines.launch

/**
 * HomeScreen
 *
 * Tela de início do app.
 *
 * @param mainApp Classe MainApp criada no começo com rememberMainApp.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose
 * @version 1.0.1 - 2023 03 14 - Column Layout no Jetpack Compose(Mudança na Column)
 * @version 1.0.2 - 2023 03 18 - Top App Bar no Jetpack Compose(Modificando titulo no LaunchedEffect)
 * @version 1.1.0 - 2023 03 19 - Drawer Menu no Jetpack Compose(Transformando em uma tela de Menu)
 */
@Composable
fun HomeScreen(
    mainApp: MainApp
) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = true, block = {
        mainApp.viewModel.topBar.setTitle(R.string.home_screen)
    })
    ColumnCenterScrollComponent {
        for (menu in AppMenu.list) {
            HomeMenuCardWidget(title = menu.name.asString(), icon = menu.icon) {
                scope.launch {
                    mainApp.navHostController.navigate(menu.route)
                    mainApp.drawerState.close()
                }
            }
        }
    }
}
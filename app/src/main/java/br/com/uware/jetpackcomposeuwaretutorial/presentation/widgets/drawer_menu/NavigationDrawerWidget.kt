package br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.drawer_menu

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp

/**
 * NavigationDrawerWidget
 *
 * Modal que contêm o menu de navegação.
 *
 * @param modifier Modifier para customização
 * @param mainApp MainApp classe centro do app
 * @param content Conteúdo do app
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 19 - Drawer Menu no Jetpack Compose
 */
@Composable
fun NavigationDrawerWidget(
    modifier: Modifier = Modifier,
    mainApp: MainApp,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        modifier = modifier.fillMaxSize(),
        drawerContent = {
            DrawerContentWidget(mainApp = mainApp)
        },
        drawerState = mainApp.drawerState,
        gesturesEnabled = mainApp.drawerState.isOpen
    ) {
        content()
    }
}
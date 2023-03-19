package br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.drawer_menu

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.menu.AppMenu
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.Purple40
import kotlinx.coroutines.launch


/**
 * DrawerContentWidget
 *
 * Conteúdo do Drawer Menu.
 *
 * @param mainApp MainApp centro do aplicativo.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 19 - Drawer Menu no Jetpack Compose
 */
@Composable
fun DrawerContentWidget(
    mainApp: MainApp
) {
    val scope = rememberCoroutineScope()
    val activity = LocalContext.current as Activity
    ModalDrawerSheet(
        drawerTonalElevation = AppDimensions.LARGE,
        drawerContainerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .background(brush = Brush.verticalGradient(listOf(Purple40, Color.White)))
                .fillMaxWidth()
                .padding(AppDimensions.LARGE),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.uware), contentDescription = null)
        }
        DrawerContentDividerWidget()
        for (menu in AppMenu.list) {
            DrawerMenuItemWidget(
                title = menu.name.asString(),
                selected = mainApp.currentRoute.contains(menu.route),
                icon = menu.icon,
                onClick = {
                    scope.launch {
                        mainApp.navHostController.navigate(menu.route)
                        mainApp.drawerState.close()
                    }
                }
            )
        }
        DrawerContentDividerWidget()
        DrawerMenuItemWidget(
            title = stringResource(id = R.string.exit),
            selected = false,
            icon = Icons.Rounded.Close,
            onClick = {
                scope.launch {
                    mainApp.drawerState.close()
                    activity.finish()
                }
            }
        )
    }
}
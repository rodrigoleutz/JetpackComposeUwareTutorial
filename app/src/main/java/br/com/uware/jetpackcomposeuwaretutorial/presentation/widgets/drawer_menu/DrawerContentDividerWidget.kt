package br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.drawer_menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions


/**
 * DrawerContentDividerWidget
 *
 * Divisor do menu.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 19 - Drawer Menu no Jetpack Compose
 */
@Composable
fun DrawerContentDividerWidget() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(AppDimensions.MINIMUM)
    )
}
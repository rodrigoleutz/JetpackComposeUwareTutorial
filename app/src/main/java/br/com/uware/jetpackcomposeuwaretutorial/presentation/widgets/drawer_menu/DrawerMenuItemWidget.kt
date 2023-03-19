package br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.drawer_menu

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.Purple40


/**
 * DrawerMenuItemWidget
 *
 * Item do drawer menu.
 *
 * @param modifier Modifier para customização.
 * @param title String de título do menu.
 * @param icon ImageVector do ícone.
 * @param selected Boolean se selecionado ou não.
 * @param onClick Ação de click.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 19 - Drawer Menu no Jetpack Compose
 */
@Composable
fun DrawerMenuItemWidget(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationDrawerItem(
        modifier = modifier
            .fillMaxWidth(),
        label = {
            Text(text = title)
        },
        selected = selected,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = title
            )
        },
        onClick = {
            onClick()
        },
        shape = RectangleShape,
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Purple40,
            selectedTextColor = Color.White,
            selectedIconColor = Color.White,
            unselectedContainerColor = Color.White,
            unselectedIconColor = Purple40,
            unselectedTextColor = Purple40
        )
    )
}
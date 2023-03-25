package br.com.uware.jetpackcomposeuwaretutorial.presentation.menu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Send
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.util.UiText
import br.com.uware.jetpackcomposeuwaretutorial.presentation.model.AppMenuPM
import br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation.AppScreens


/**
 * AppMenu
 *
 * Lista dos menus da aplicação.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 19 - Drawer Menu no Jetpack Compose
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
class AppMenu {
    companion object {
        val list = listOf<AppMenuPM>(
            AppMenuPM(
                name = UiText.StringResource(R.string.home_screen),
                icon = Icons.Rounded.Home,
                route = AppScreens.HomeScreen.name
            ),
            AppMenuPM(
                name = UiText.StringResource(R.string.name_screen),
                icon = Icons.Rounded.Send,
                route = AppScreens.NameInputScreen.name
            ),
            AppMenuPM(
                name = UiText.StringResource(R.string.imc_screen),
                icon = Icons.Rounded.Check,
                route = AppScreens.ImcScreen.name
            )
        )
    }
}
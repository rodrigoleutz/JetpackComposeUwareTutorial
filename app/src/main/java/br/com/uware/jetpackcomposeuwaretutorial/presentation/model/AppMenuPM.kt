package br.com.uware.jetpackcomposeuwaretutorial.presentation.model

import androidx.compose.ui.graphics.vector.ImageVector
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.util.UiText

/**
 * AppMenuPM
 *
 * Application Menu Presentation Model
 *
 * @param name Name of menu
 * @param icon ImageVector for icon
 * @param route Route to screen
 * @author Rodrigo Leutz
 * @versio 1.0.0 - 2023 03 19 - Drawer Menu no Jetpack Compose
 */
data class AppMenuPM(
    val name: UiText,
    val icon: ImageVector,
    val route: String
)

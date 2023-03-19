package br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.top_bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.top_bar.TopBarState


/**
 * TopAppBarWidget
 *
 * Barra da aplicação.
 *
 * @param topBar TopBarState que é injetado no PresentationModule.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 18 - Top App Bar no Jetpack Compose
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWidget(
    topBar: TopBarState
) {
    val isEnabled = remember {
        topBar.isEnabled
    }
    val title = remember {
        topBar.title
    }
    val containerColor = remember {
        topBar.containerColor
    }
    val contentColor = remember {
        topBar.contentColor
    }
    AnimatedVisibility(visible = isEnabled.value) {
        TopAppBar(
            title = {
                Text(text = title.value)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = containerColor.value,
                titleContentColor = contentColor.value,
                actionIconContentColor = contentColor.value,
                navigationIconContentColor = contentColor.value
            )
        )
    }
}
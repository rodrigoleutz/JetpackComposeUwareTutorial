package br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.top_bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.top_bar.TopBarState
import kotlinx.coroutines.launch


/**
 * TopAppBarWidget
 *
 * Barra da aplicação.
 *
 * @param topBar TopBarState que é injetado no PresentationModule.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 18 - Top App Bar no Jetpack Compose
 * @version 1.0.0 - 2023 03 19 - Drawer Menu no Jetpack Compose(Adição do ícone de menu)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWidget(
    topBar: TopBarState,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()
    val topBarState = remember {
        mutableStateOf<TopBarState>(topBar)
    }
    AnimatedVisibility(visible = topBarState.value.isEnabled.value) {
        TopAppBar(
            title = {
                Text(text = topBarState.value.title.value)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = topBarState.value.containerColor.value,
                titleContentColor = topBarState.value.contentColor.value,
                actionIconContentColor = topBarState.value.contentColor.value,
                navigationIconContentColor = topBarState.value.contentColor.value
            ),
            navigationIcon = {
                IconButton(
                    onClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
                }
            }
        )
    }
}
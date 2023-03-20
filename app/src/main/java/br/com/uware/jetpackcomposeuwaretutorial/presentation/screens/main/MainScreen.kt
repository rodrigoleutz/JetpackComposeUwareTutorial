package br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.loading.LoadingState
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.Purple40
import br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.drawer_menu.NavigationDrawerWidget
import br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.top_bar.TopAppBarWidget
import kotlinx.coroutines.launch

/**
 * MainScreen
 *
 * Tela principal onde as outras telas vão ser carregadas.
 *
 * @param mainApp MainApp parte que controla a tela da aplicaçãoq.
 * @param content Conteúdo da tela.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 18 - Top App Bar no Jetpack Compose
 * @version 1.0.1 - 2023 03 19 - Drawer Menu no Jetpack Compose(Adição NavigationDrawerWidget e drawerstate na Top App Bar)
 * @version 1.0.2 - 2023 03 19 - Loading no Jetpack Compose(Adicionando Snackbar e LinearProgressIndicator)
 */
@Composable
fun MainScreen(
    mainApp: MainApp,
    content: @Composable () -> Unit
) {
    val loading = remember {
        mainApp.viewModel.loading
    }
    val scope = rememberCoroutineScope()
    val snackbarOpen = rememberSaveable {
        mutableStateOf(false)
    }
    NavigationDrawerWidget(mainApp = mainApp) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBarWidget(
                    topBar = mainApp.viewModel.topBar,
                    drawerState = mainApp.drawerState
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                AnimatedVisibility(loading.loading.value == LoadingState.LoadingType.Loading) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter),
                        color = loading.color.value,
                        trackColor = loading.trackColor.value
                    )
                }
                AnimatedVisibility(visible = loading.loading.value == LoadingState.LoadingType.Error) {
                    snackbarOpen.value = true
                    LaunchedEffect(key1 = snackbarOpen.value, block = {
                        scope.launch {
                            mainApp.snackbarHostState.showSnackbar(
                                message = loading.errorMessage.value,
                                duration = SnackbarDuration.Indefinite,
                                withDismissAction = true
                            )
                        }
                    })
                }
                content()
                SnackbarHost(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    hostState = mainApp.snackbarHostState,
                    snackbar = { _ ->
                        Snackbar(
                            modifier = Modifier
                                .padding(AppDimensions.MEDIUM)
                                .border(
                                    AppDimensions.SMALLEST,
                                    Color.White,
                                    RoundedCornerShape(AppDimensions.SMALL)
                                ),
                            containerColor = Purple40,
                            contentColor = Color.White,
                            shape = RoundedCornerShape(AppDimensions.SMALL),
                            dismissAction = {
                                IconButton(
                                    onClick = {
                                        snackbarOpen.value = false
                                        mainApp.snackbarHostState.currentSnackbarData?.dismiss()
                                        mainApp.viewModel.loading.end()
                                    }
                                ) {
                                    Icon(
                                        modifier = Modifier,
                                        imageVector = Icons.Rounded.Close,
                                        contentDescription = null
                                    )
                                }
                            },
                            dismissActionContentColor = Color.White
                        ) {
                            Text(
                                text = mainApp.viewModel.loading.errorMessage.value,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                )
            }
        }
    }
}
package br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.top_bar.TopAppBarWidget

/**
 * MainScreen
 *
 * Tela principal onde as outras telas vão ser carregadas.
 *
 * @param mainApp MainApp parte que controla a tela da aplicaçãoq.
 * @param content Conteúdo da tela.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 18 - Top App Bar no Jetpack Compose
 */
@Composable
fun MainScreen(
    mainApp: MainApp,
    content: @Composable () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBarWidget(topBar = mainApp.viewModel.topBar)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            content()
        }
    }
}
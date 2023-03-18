package br.com.uware.jetpackcomposeuwaretutorial.presentation.components.layouts.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


/**
 * ColumCenterScrollComponent
 *
 * Componente de coluna com objetos centralizados de tamanho máximo e possibilidade de scroll.
 *
 * @param modifier Modifier da Column case precise customizar.
 * @param content Conteúdo da Column.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 14 - Column Layout no Jetpack Compose
 */
@Composable
fun ColumnCenterScrollComponent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        content()
    }
}
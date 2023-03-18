package br.com.uware.jetpackcomposeuwaretutorial.presentation.components.layouts.column

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * ColumCenterComponent
 *
 * Componente de coluna com objetos centralizados de tamanho máximo.
 *
 * @param modifier Modifier da Column case precise customizar.
 * @param content Conteúdo da Column.
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 14 - Column Layout no Jetpack Compose
 */
@Composable
fun ColumnCenterComponent(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        content()
    }
}
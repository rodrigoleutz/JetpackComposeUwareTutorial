package br.com.uware.jetpackcomposeuwaretutorial.presentation.widgets.cards

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.Purple40


/**
 * HomeMenuCardWidget
 *
 * Card para menu da HomeScreen
 *
 * @param title String de título
 * @param icon ImageVector com o ícone
 * @param onClick Função quando clicado
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 19 - Drawer Menu no Jetpack Compose
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMenuCardWidget(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(AppDimensions.MEDIUM),
        onClick = {
            onClick()
        },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Purple40
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = AppDimensions.MEDIUM,
            pressedElevation = AppDimensions.NONE
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimensions.LARGE)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(end = AppDimensions.MEDIUM),
                    imageVector = icon,
                    contentDescription = title
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
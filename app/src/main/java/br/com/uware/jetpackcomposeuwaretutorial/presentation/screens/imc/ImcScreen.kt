package br.com.uware.jetpackcomposeuwaretutorial.presentation.screens.imc

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.uware.jetpackcomposeuwaretutorial.R
import br.com.uware.jetpackcomposeuwaretutorial.presentation.components.buttons.elevated.ButtonElevatedComponent
import br.com.uware.jetpackcomposeuwaretutorial.presentation.components.layouts.column.ColumnCenterComponent
import br.com.uware.jetpackcomposeuwaretutorial.presentation.components.texts.input_field.InputFieldComponent
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.MainApp
import br.com.uware.jetpackcomposeuwaretutorial.presentation.core.states.loading.LoadingState
import br.com.uware.jetpackcomposeuwaretutorial.presentation.theme.AppDimensions


/**
 * ImcScreen
 *
 * Tela da calculadora de imc
 *
 * @param mainApp Centro do controle da tela no aplicativo.
 * @param viewModel ViewModel para calcular o imc.
 * @author Rodrigo Leutz
 * @version 1.6.0 - 2023 03 21 - Calculadora de IMC no Jetpack Compose
 */
@Composable
fun ImcScreen(
    mainApp: MainApp,
    viewModel: ImcViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val height = remember {
        mutableStateOf("")
    }
    val weight = remember {
        mutableStateOf("")
    }
    val expanded = rememberSaveable {
        mutableStateOf(false)
    }
    val buttonText = remember(expanded.value) {
        mutableStateOf(
            if (expanded.value) context.getString(R.string.close) else context.getString(
                R.string.calculate
            )
        )
    }
    LaunchedEffect(key1 = true, block = {
        mainApp.viewModel.topBar.setTitle(R.string.imc_screen)
    })
    ColumnCenterComponent {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimensions.LARGE),
            elevation = CardDefaults.cardElevation(
                defaultElevation = AppDimensions.LARGE
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppDimensions.MEDIUM)
            ) {
                InputFieldComponent(
                    valueState = weight,
                    label = stringResource(id = R.string.weight),
                    keyboardType = KeyboardType.Number
                )
                InputFieldComponent(
                    valueState = height,
                    label = stringResource(id = R.string.height),
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
                AnimatedVisibility(visible = expanded.value) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(AppDimensions.MEDIUM),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = viewModel.imcData.value?.imc.toString(),
                            color = viewModel.imcData.value?.color ?: Color.White,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = viewModel.imcData.value?.string.toString(),
                            color = viewModel.imcData.value?.color ?: Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                ButtonElevatedComponent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(AppDimensions.LARGE),
                    label = buttonText.value
                ) {
                    if (!expanded.value) viewModel.calculateImc(height.value, weight.value)
                    else {
                        height.value = ""
                        weight.value = ""
                    }
                    if(mainApp.viewModel.loading.loading.value != LoadingState.LoadingType.Error) {
                        expanded.value = !expanded.value
                        focusManager.clearFocus()
                    }
                }
            }
        }
    }
}
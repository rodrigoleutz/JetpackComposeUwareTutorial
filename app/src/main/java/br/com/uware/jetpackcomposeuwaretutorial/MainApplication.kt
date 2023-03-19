package br.com.uware.jetpackcomposeuwaretutorial

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * MainApplication
 *
 * Leva a anotação de HiltAndroidApp que diz que é uma aplicação com injeção de dependência
 * pelo Dagger Hilt(Inserido na application do manifest como name).
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 18 - Top App Bar no Jetpack Compose
 */
@HiltAndroidApp
class MainApplication: Application() {
}
package br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation

/**
 * AppScreens
 *
 * Local onde ficam o nome das telas do aplicativo.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose(HomeScreen, NameScreen, SplashScreen)
 * @version 1.4.0 - 2023 03 19 - Drawer Menu no Jetpack Compose(NameInputScreen)
 * @version 1.6.0 - 2023 03 20 - Calculadora de IMC no Jetpack Compose(Adicionado ImcScreen)
 */
enum class AppScreens {
    HomeScreen,
    ImcScreen,
    NameInputScreen,
    NameScreen,
    SplashScreen;
    companion object {
        /**
         * fromRoute
         *
         * Função que envia a rota que está sendo chamada.
         *
         * @param route String da rota a ser chamada.
         * @author Rodrigo Leutz
         * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose(HomeScreen, NameScreen, SplashScreen, null, else)
         * @version 1.6.0 - 2023 03 20 - Calculadora de IMC no Jetpack Compose(Adicionado ImcScreen)
         */
        fun fromRoute(route: String?) =
            when(route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                ImcScreen.name -> ImcScreen
                NameInputScreen.name -> NameInputScreen
                NameScreen.name -> NameScreen
                SplashScreen.name -> SplashScreen
                null -> SplashScreen
                else -> throw IllegalArgumentException("Rota $route não foi encontrada.")
            }
    }
}
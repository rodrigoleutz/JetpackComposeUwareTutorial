package br.com.uware.jetpackcomposeuwaretutorial.presentation.navigation

/**
 * AppScreens
 *
 * Local onde ficam o nome das telas do aplicativo.
 *
 * @author Rodrigo Leutz
 * @version 1.0.0 - 2023 03 13 - Navigation no Jetpack Compose(HomeScreen, NameScreen, SplashScreen)
 * @version 1.0.1 - 2023 03 19 - Drawer Menu no Jetpack Compose(NameInputScreen)
 */
enum class AppScreens {
    HomeScreen,
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
         */
        fun fromRoute(route: String?) =
            when(route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                NameInputScreen.name -> NameInputScreen
                NameScreen.name -> NameScreen
                SplashScreen.name -> SplashScreen
                null -> SplashScreen
                else -> throw IllegalArgumentException("Rota $route não foi encontrada.")
            }
    }
}
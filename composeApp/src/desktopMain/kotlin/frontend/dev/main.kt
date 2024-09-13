package frontend.dev

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import cafe.adriel.voyager.navigator.Navigator
import frontend.dev.core.main.MainScreen
import frontend.dev.di.KoinInit
import org.koin.core.Koin


lateinit var koin: Koin

fun main()  {
    koin = KoinInit().init( )
    koin.loadModules(
        listOf()
    )
    return application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "TrafficAccountingApp",
            state = rememberWindowState(
                width = 1440.dp,
                height = 1024.dp
            ),
        ) {
            Box(
                modifier = Modifier.fillMaxSize().padding(16.dp),
            ){
                Navigator(MainScreen())
            }
        }
    }

}
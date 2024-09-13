package frontend.dev.core.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import frontend.dev.App
import frontend.dev.AppContentBox
import frontend.dev.TrafficHistory
import frontend.dev.core.domain.NetworkTraffic
import frontend.dev.core.presentation.component.AppNavigationRailBar
import frontend.dev.core.presentation.component.AppPage
import frontend.dev.core.presentation.component.AppTab
import frontend.dev.core.presentation.component.NetworkTrafficTable
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class MainScreen: Screen {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @Composable
    override fun Content() {
        val windowSizeClass = calculateWindowSizeClass()
        val useNavRail = windowSizeClass.widthSizeClass > WindowWidthSizeClass.Compact

        TabNavigator(
            AppTab.HomeTab
        ){
            val tabNavigator = LocalTabNavigator.current
            if (useNavRail) {
                Row {
                    val color = 0xFFEFF4F8
                    AppNavigationRailBar(
                        modifier = Modifier.background(Color(color)),
                        tabNavigator = it,
                        navRailItems = listOf(
                            AppTab.HomeTab,
                            AppTab.HomeTab,
                        ),

                    )
                    CurrentScreen()
                    Column {
                        AppPage(
                            firstLineHeaderText = "Perfomance",
                            secondLineHeaderText = "Calculate overall network traffic",
                            firstContent = { TrafficHistory(modifier = Modifier.weight(1f)) },
                            secondContent = { TrafficHistory(modifier = Modifier.weight(1f)) },
                            fourthContent = { TrafficHistory(modifier = Modifier.weight(1f)) },
                        )
                    }
                }

            } else {
                Scaffold(
                    content = { innerPadding ->
                        Box(
                            modifier = Modifier
                                .padding(innerPadding),
                        ) {
                            CurrentScreen()
                        }
                    },

                )
            }
        }
    }


}
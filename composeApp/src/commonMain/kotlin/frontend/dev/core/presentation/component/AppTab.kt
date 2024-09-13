package frontend.dev.core.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import frontend.dev.core.main.MainScreen
import org.jetbrains.compose.resources.painterResource
import trafficaccountingapp.composeapp.generated.resources.Res
import trafficaccountingapp.composeapp.generated.resources.home_filled

internal sealed class AppTab{
    internal object HomeTab: Tab{
        override val options: TabOptions
            @Composable
            get()  {
                val title = "Home"
                val icon = painterResource(Res.drawable.home_filled)

                return remember {
                    TabOptions(
                        index = 0u,
                        title = title,
                        icon = icon,
                    )
                }
            }
        @Composable
        override fun Content() {
            MainScreen()
        }
    }
}
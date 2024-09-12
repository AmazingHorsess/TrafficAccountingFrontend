package frontend.dev.core.presentation.utils

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.tab.Tab
import org.jetbrains.compose.resources.painterResource
import trafficaccountingapp.composeapp.generated.resources.Res
import trafficaccountingapp.composeapp.generated.resources.home_filled
@Composable
fun FilledIcon(item: Tab) = when (item.options.index){
    (0u).toUShort() -> painterResource(Res.drawable.home_filled)
    else -> painterResource(Res.drawable.home_filled)
}
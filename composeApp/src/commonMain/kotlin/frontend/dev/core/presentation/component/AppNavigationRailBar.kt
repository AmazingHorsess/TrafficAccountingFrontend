package frontend.dev.core.presentation.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Applier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import frontend.dev.core.presentation.utils.FilledIcon

@Composable
fun AppNavigationRailBar(
    modifier: Modifier = Modifier,
    tabNavigator: TabNavigator,
    navRailItems: List<Tab>,
) {
    val color = Color(0xFFEFF4F8)
    NavigationRail(
        modifier = modifier.fillMaxHeight().alpha(0.95f),
        containerColor =  color,
        header = {
            Icon(
                modifier = Modifier.size(42.dp),
                imageVector = Icons.Default.AccountBox,
                contentDescription = null,
            )
        },
        contentColor = MaterialTheme.colorScheme.onSurface,
    ){
        navRailItems.forEach { item ->
            val isSelected = tabNavigator.current == item
            NavigationRailItem(
                modifier = Modifier.padding(vertical = 12.dp),
                icon = {
                    item.options.icon?.let {
                        Icon(
                            painter = if (isSelected) {
                                FilledIcon(item)
                            } else {
                                it
                            },
                            contentDescription = item.options.title,
                        )
                    }
                },
                label = { Text(text = item.options.title) },
                alwaysShowLabel = true,
                selected = tabNavigator.current == item,
                onClick = { tabNavigator.current = item },
            )
        }
    }
}
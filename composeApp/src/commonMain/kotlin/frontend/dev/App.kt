package frontend.dev


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import frontend.dev.core.domain.NetworkTraffic
import frontend.dev.core.presentation.component.NetworkTrafficTable
import frontend.dev.core.presentation.theme.TrafficAccountingTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    TrafficAccountingTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxSize(),) {
            NetworkTrafficTable(data = listOf(
                NetworkTraffic(
                source_ip = "192.168.1.10",
                destination_ip = "172.16.0.5",
                packet_length = 123456, source_port = 443,
                destination_port = 80, username = "user1",
                timestamp = "2024-09-13 12:34:56"
                )
                )
            )

        }
    }
}
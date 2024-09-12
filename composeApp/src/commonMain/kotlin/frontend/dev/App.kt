package frontend.dev

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import frontend.dev.core.domain.NetworkTraffic
import frontend.dev.core.presentation.component.NetworkTrafficItem
import frontend.dev.core.presentation.component.NetworkTrafficList
import frontend.dev.core.presentation.theme.TrafficAccountingTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import trafficaccountingapp.composeapp.generated.resources.Res
import trafficaccountingapp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    TrafficAccountingTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            NetworkTrafficItem(
                NetworkTraffic(
                    source_ip = "192.168.1.10",
                    destination_ip = "172.16.0.5",
                    packet_length = 123456, source_port = 443,
                    destination_port = 80, username = "user1",
                    timestamp = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
                ),
                onClick = {

                },
            )
            NetworkTrafficList(
                trafficData = listOf(NetworkTraffic(
                    source_ip = "192.168.1.10",
                    destination_ip = "172.16.0.5",
                    packet_length = 123456, source_port = 443,
                    destination_port = 80, username = "user1",
                    timestamp = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
                )),
                onItemClick = {},


            )
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}
package frontend.dev

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import frontend.dev.core.domain.NetworkTraffic
import frontend.dev.core.main.MainScreen
import frontend.dev.core.presentation.component.AppPage
import frontend.dev.core.presentation.component.NetworkTrafficTable
import frontend.dev.core.presentation.theme.Red
import frontend.dev.core.presentation.theme.TrafficAccountingTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.toLocalDateTime
import org.koin.compose.KoinContext


@Composable
fun TrafficAccountingApp(

) {
    KoinContext {
        TrafficAccountingTheme {
           Column {
               AppPage(
                   firstLineHeaderText = "Perfomance",
                   secondLineHeaderText = "Calculate overall network traffic",
                   firstContent = {TrafficHistory(modifier = Modifier.weight(1f))},
                   secondContent = {TrafficHistory(modifier = Modifier.weight(1f))},
                   fourthContent = {TrafficHistory(modifier = Modifier.weight(1f))},
               )
           }
        }

    }
}
@Composable
fun Header(
    firstLineHeaderText: String,
    secondLineHeaderText: String,

) {
    val color = Color(0xFFEFF4F8)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color)
    ) {
        Column {
            Text(
                firstLineHeaderText,
                color = Color(0xFF353535),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                secondLineHeaderText,
                color = Color(0xFF454A4C),
                style = MaterialTheme.typography.bodySmall,

                )

        }


    }
}

@Composable
fun TrafficHistory(modifier: Modifier = Modifier) {
    val headerColor = Color(0xFFEFF4F8)
    val contentColor = Color.White

    Card(
        modifier = modifier.padding(end = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(headerColor)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Traffic History",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface
                )
                // Здесь можно добавить поле поиска или другие элементы заголовка
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(contentColor)
                    .padding(16.dp)
            ) {
                NetworkTrafficTable(
                    data = listOf(
                        NetworkTraffic(
                            source_ip = "192.168.1.10",
                            destination_ip = "172.16.0.5",
                            packet_length = 123456, source_port = 443,
                            destination_port = 80, username = "user1",
                            timestamp = "2024-09-13 12:34:56"

                ),
                        NetworkTraffic(
                            source_ip = "192.168.1.10",
                            destination_ip = "172.16.0.5",
                            packet_length = 123456, source_port = 443,
                            destination_port = 80, username = "user1",
                            timestamp = "2024-09-13 12:34:56"
                        ),
                        NetworkTraffic(
                            source_ip = "192.168.1.10",
                            destination_ip = "172.16.0.5",
                            packet_length = 123456, source_port = 443,
                            destination_port = 80, username = "user1",
                            timestamp = "2024-09-13 12:34:56"
                        ),
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
}



@Composable
fun AppContentBox(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    headerColor: Color = MaterialTheme.colorScheme.primary,
    bottomColor: Color = MaterialTheme.colorScheme.primary,
) {
    Box(
        modifier = modifier
            .width(300.dp)
            .height(280.dp)
            .background(Color.Red),

        ) {

    }
}









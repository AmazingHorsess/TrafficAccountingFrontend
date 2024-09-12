package frontend.dev.core.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import frontend.dev.core.domain.NetworkTraffic
import org.jetbrains.compose.resources.Font
import trafficaccountingapp.composeapp.generated.resources.Res
import trafficaccountingapp.composeapp.generated.resources.montserrat_regular
@Composable
fun NetworkTrafficList(
    trafficData: List<NetworkTraffic>,
    onItemClick: (NetworkTraffic) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Заголовки таблицы
        NetworkTrafficHeader()

        // Список данных
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(trafficData) { networkTraffic ->
                NetworkTrafficItem(
                    networkTraffic = networkTraffic,
                    onClick = { onItemClick(networkTraffic) },
                )
            }
        }
    }
}
@Composable
fun NetworkTrafficItem(
    networkTraffic: NetworkTraffic,
    onClick: () -> Unit,
) {
    // Ровный элемент данных с фиксированной шириной
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = usernameCondition(networkTraffic),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = networkTraffic.source_ip,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = networkTraffic.destination_ip,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = networkTraffic.source_port.toString(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = networkTraffic.destination_port.toString(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = networkTraffic.packet_length.toString(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = networkTraffic.timestamp.toString(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
    }
}
@Composable
fun NetworkTrafficHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(text = "Username", style = MaterialTheme.typography.bodySmall)
        Text(text = "Source IP", style = MaterialTheme.typography.bodySmall)
        Text(text = "Destination IP", style = MaterialTheme.typography.bodySmall)
        Text(text = "Source Port", style = MaterialTheme.typography.bodySmall)
        Text(text = "Destination Port", style = MaterialTheme.typography.bodySmall)
        Text(text = "Packet Length", style = MaterialTheme.typography.bodySmall)
        Text(text = "Timestamp", style = MaterialTheme.typography.bodySmall)
    }
}

private fun usernameCondition(networkTraffic: NetworkTraffic):String{
    if (networkTraffic.username != null){
        return networkTraffic.username
    } else {
        return "No username"
    }
}
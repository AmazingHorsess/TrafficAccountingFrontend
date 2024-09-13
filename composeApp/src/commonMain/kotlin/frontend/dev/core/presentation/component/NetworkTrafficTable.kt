package frontend.dev.core.presentation.component


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import frontend.dev.core.domain.NetworkTraffic



@Composable
fun NetworkTrafficTable(data: List<NetworkTraffic>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
            TableCell(text = "Username", weight = 1f)
            TableCell(text = "Source IP", weight = 1.2f)
            TableCell(text = "Source Port", weight = 1f)
            TableCell(text = "Destination IP", weight = 1f)
            TableCell(text = "Destination Port", weight = 1f)
            TableCell(text = "Packet Length", weight = 1.2f)
            TableCell(text = "Date", weight = 1.2f)
        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth())

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(data.size) { index ->
                val item = data[index]
                Row(modifier = Modifier.fillMaxWidth().padding(vertical = 0.0                                 .dp, horizontal = 8.dp)) {
                    TableCell(text = item.username ?: "Unknown", weight = 1f)
                    TableCell(text = item.source_ip, weight = 1.2f)
                    TableCell(text = item.source_port.toString(), weight = 1f)
                    TableCell(text = item.destination_ip, weight = 1f)
                    TableCell(text = item.destination_port.toString(), weight = 1f)
                    TableCell(text = "${item.packet_length}M", weight = 1.2f)
                    TableCell(
                        text = item.timestamp,
                        weight = 1.2f
                    )
                }
            }
        }
    }
}

@Composable
private fun RowScope.TableCell(text: String, weight: Float) {
    Text(
        text = text,
        modifier = Modifier
            .weight(weight)
            .padding(2.dp),
        style = MaterialTheme.typography.bodySmall,
        fontSize = 10.sp,
        textAlign = TextAlign.Left,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

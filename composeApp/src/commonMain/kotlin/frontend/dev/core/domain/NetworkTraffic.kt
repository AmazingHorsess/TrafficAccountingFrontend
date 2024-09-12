package frontend.dev.core.domain

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class NetworkTraffic(
    val source_ip: String,
    val destination_ip: String,
    val packet_length: Int,
    val source_port: Int,
    val destination_port: Int,
    val username: String? = null,
    val timestamp: LocalDateTime,
)
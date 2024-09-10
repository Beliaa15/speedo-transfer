package com.belia.speedotransfer.util

import java.time.LocalDate
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun formatDate(input: String): String {
    // Parse the input string to ZonedDateTime
    val zonedDateTime = ZonedDateTime.parse(input)

    // Convert ZonedDateTime to LocalDateTime
    val localDateTime = zonedDateTime.withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime()

    // Get today's and yesterday's dates
    val today = LocalDate.now(ZoneOffset.UTC)
    val yesterday = today.minusDays(1)

    // Get the date part from the input timestamp
    val inputDate = localDateTime.toLocalDate()

    // Define the time formatter (for HH:mm)
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    // Check if the date is today or yesterday
    return when (inputDate) {
        today -> "Today ${localDateTime.format(timeFormatter)}"
        yesterday -> "Yesterday ${localDateTime.format(timeFormatter)}"
        else -> {
            // Define the formatter for dd-MM-yyyy HH:mm format
            val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
            localDateTime.format(dateTimeFormatter)
        }
    }
}
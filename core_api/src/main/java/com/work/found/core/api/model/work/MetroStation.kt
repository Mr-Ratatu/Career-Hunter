package com.work.found.core.api.model.work

data class MetroStation(
    val lat: Double,
    val line_id: String,
    val line_name: String,
    val lng: Double,
    val station_id: String,
    val station_name: String
)
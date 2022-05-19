package com.work.found.core.api.model.work

data class Address(
    val building: String,
    val city: String,
    val description: Any,
    val id: String,
    val lat: Double,
    val lng: Double,
    val metro: Metro,
    val metro_stations: List<MetroStation>,
    val raw: String,
    val street: String
)
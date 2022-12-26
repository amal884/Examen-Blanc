package com.tarmoun.commonapi.dtos

data class RadarRequestDTO(
        val vitesseMax: Int = 0,
        val longtitude: Double = 0.0,
        val latitude: Double = 0.0
)
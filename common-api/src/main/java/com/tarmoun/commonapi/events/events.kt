package com.tarmoun.commonapi.events

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseEvent<T>(
        @TargetAggregateIdentifier
        open val  id : T
)

data class RadarCreatedEvent(
        override val id : String,
        val vitesseMax: Int,
        val longtitude: Double,
        val latitude: Double
): BaseEvent<String>(id)

data class RadarUpdatedEvent(
        override val id : String,
        val vitesseMax: Int,
        val longtitude: Double,
        val latitude: Double
): BaseEvent<String>(id)
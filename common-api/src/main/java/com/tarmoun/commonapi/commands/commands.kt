package com.tarmoun.commonapi.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier
import org.bouncycastle.its.asn1.Latitude

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier
        open val  id : T
)

data class CreateRadarCommand(
       override val id : String,
        val vitesseMax: Int,
        val longtitude: Double,
        val latitude: Double
       ): BaseCommand<String>(id)

data class UpdateRadarCommand(
        override val id : String,
        val vitesseMax: Int,
        val longtitude: Double,
        val latitude: Double
): BaseCommand<String>(id)
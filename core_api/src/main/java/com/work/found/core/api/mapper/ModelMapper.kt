package com.work.found.core.api.mapper

interface ModelMapper<INT, EXT> {

    fun mapToInternalLayer(externalLayerModel: EXT): INT

    fun mapToExternalLayer(internalLayerModel: INT): EXT
}
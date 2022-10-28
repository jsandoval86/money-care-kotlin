package com.moneycare.tracking.tags.rest.mappers

import com.moneycare.tracking.tags.entities.TagEntity
import com.moneycare.tracking.tags.rest.response.TagResponse
import org.springframework.stereotype.Component

@Component
class TagResponseMapper {

    fun mapToResponse(tagEntity: TagEntity): TagResponse {
        return TagResponse(
            tagEntity.id, tagEntity.name, tagEntity.type
        )
    }
}
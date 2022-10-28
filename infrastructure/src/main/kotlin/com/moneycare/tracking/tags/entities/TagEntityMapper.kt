package com.moneycare.tracking.tags.entities

import com.moneycare.tracking.tags.Tag
import org.springframework.stereotype.Component

@Component
class TagEntityMapper {
    fun mapToEntity(tag: Tag) : TagEntity {
        return TagEntity(tag.id, tag.tag, tag.type)
    }

    fun mapToDomain(tagEntity: TagEntity): Tag {
        return Tag.of(
            tagEntity.id, tagEntity.name, tagEntity.type
        )
    }
}
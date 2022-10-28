package com.moneycare.tracking.tags

import java.util.UUID

class Tag private constructor(
    var id : String,
    var tag : String,
    var type: TagType
){

    companion object {

        fun create(tag : String, type: TagType) : Tag = of(UUID.randomUUID().toString(), tag, type)

        fun undefined() : Tag = of("0000", "no tag", TagType.no_type)

        fun of(id : String, tag : String, type: TagType): Tag {
            return Tag(id, tag, type)
        }

    }

}
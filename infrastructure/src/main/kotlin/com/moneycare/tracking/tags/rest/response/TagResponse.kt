package com.moneycare.tracking.tags.rest.response

import com.moneycare.tracking.tags.TagType

data class TagResponse(
    var id: String,
    var name: String,
    var type: TagType
)
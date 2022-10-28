package com.moneycare.tracking.tags.rest.request

import com.moneycare.tracking.tags.TagType
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class CreateTagRequest {
    @NotEmpty
    lateinit var name: String
    @NotNull
    lateinit var type: TagType
}
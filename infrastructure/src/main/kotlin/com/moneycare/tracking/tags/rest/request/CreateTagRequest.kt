package com.moneycare.tracking.tags.rest.request

import com.moneycare.tracking.tags.TagType
import javax.validation.constraints.NotEmpty

class CreateTagRequest {
    @NotEmpty
    lateinit var name: String
    @NotEmpty
    lateinit var type: TagType
}
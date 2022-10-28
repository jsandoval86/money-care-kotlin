package com.moneycare.tracking.tags.rest

import com.moneycare.tracking.tags.CreateTagCommand
import com.moneycare.tracking.tags.CreateTagUseCase
import com.moneycare.tracking.tags.rest.request.CreateTagRequest
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(URLTags.URL, consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
class TagsController(
    private var createTagUseCase: CreateTagUseCase
) {

    @PostMapping
    fun create(@RequestBody request: CreateTagRequest) {
        val command = CreateTagCommand(request.name, request.type)
        createTagUseCase.create(command)
    }
}
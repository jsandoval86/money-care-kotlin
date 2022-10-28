package com.moneycare.tracking.tags.rest

import com.moneycare.tracking.tags.CreateTagCommand
import com.moneycare.tracking.tags.CreateTagUseCase
import com.moneycare.tracking.tags.entities.TagEntity
import com.moneycare.tracking.tags.repository.TagRepositoryJPA
import com.moneycare.tracking.tags.rest.mappers.TagResponseMapper
import com.moneycare.tracking.tags.rest.request.CreateTagRequest
import com.moneycare.tracking.tags.rest.response.TagResponse
import com.sipios.springsearch.anotation.SearchSpec
import org.springframework.data.jpa.domain.Specification
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping(URLTags.URL)
@Validated
open class TagsController(
    private var createTagUseCase: CreateTagUseCase,
    private var tagRepositoryJPA: TagRepositoryJPA,
    private var tagResponseMapper: TagResponseMapper
) {

    @PostMapping
    open fun create(@RequestBody @Valid request: CreateTagRequest) {
        val command = CreateTagCommand(request.name, request.type)
        createTagUseCase.create(command)
    }

    @GetMapping
    open fun get(@SearchSpec(caseSensitiveFlag = false) search: Specification<TagEntity>?) : List<TagResponse> {
        return tagRepositoryJPA.findAll(Specification.where(search))
            .map { tagEntity ->
                tagResponseMapper.mapToResponse(tagEntity)
            }
    }

}
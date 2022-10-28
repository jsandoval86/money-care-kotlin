package com.moneycare.tracking.tags

import org.springframework.transaction.annotation.Transactional
import javax.inject.Named

@Named
open class CreateTagUseCase(
    private var tagRepository: TagRepository
) {

    @Transactional
    open fun create(command: CreateTagCommand) : Tag {
        val tag = Tag.create(command.getName(), command.getType())
        tagRepository.save(tag)

        return tag
    }
}
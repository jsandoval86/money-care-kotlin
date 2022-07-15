package com.moneycare.tracking.tags.repository

import com.moneycare.tracking.shared.models.Tag
import com.moneycare.tracking.shared.repository.TagRepository
import com.moneycare.tracking.tags.entities.TagEntityMapper
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
open class TagRepositoryBD(
    private var tagRepositoryJPA: TagRepositoryJPA,
    private var tagEntityMapper: TagEntityMapper
) : TagRepository {

    override fun findById(id: String): Optional<Tag> {
        println(id)
        return Optional.empty()
    }

    override fun save(tag: Tag) {
        val tagEntity = tagEntityMapper.mapToEntity(tag)
        tagRepositoryJPA.save(tagEntity)
    }

}
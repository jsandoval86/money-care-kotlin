package com.moneycare.tracking.tags.repository

import com.moneycare.tracking.tags.Tag
import com.moneycare.tracking.tags.TagRepository
import com.moneycare.tracking.tags.entities.TagEntityMapper
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
open class TagRepositoryBD(
    private var tagRepositoryJPA: TagRepositoryJPA,
    private var tagEntityMapper: TagEntityMapper
) : TagRepository {

    override fun findById(id: String): Optional<Tag> {
        val tagEntityOptional = tagRepositoryJPA.findById(id)

        return if( tagEntityOptional.isPresent)
            Optional.of(tagEntityMapper.mapToDomain(tagEntityOptional.get()))
        else
            Optional.empty()

    }

    override fun save(tag: Tag) {
        val tagEntity = tagEntityMapper.mapToEntity(tag)
        tagRepositoryJPA.save(tagEntity)
    }

}
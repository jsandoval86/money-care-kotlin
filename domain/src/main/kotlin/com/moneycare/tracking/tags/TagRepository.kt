package com.moneycare.tracking.tags

import java.util.Optional

interface TagRepository {

    fun findById(id : String) : Optional<Tag>

    fun save(tag: Tag)
}
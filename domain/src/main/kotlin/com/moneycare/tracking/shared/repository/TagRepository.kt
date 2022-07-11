package com.moneycare.tracking.shared.repository

import com.moneycare.tracking.shared.models.Tag
import java.util.Optional

interface TagRepository {

    fun findById(id : String) : Optional<Tag>

}
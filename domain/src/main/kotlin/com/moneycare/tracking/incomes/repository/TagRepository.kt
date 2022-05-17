package com.moneycare.tracking.incomes.repository

import com.moneycare.tracking.incomes.models.Tag
import java.util.Optional
import java.util.UUID

interface TagRepository {

    fun findById(id : String) : Optional<Tag>

}
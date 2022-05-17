package com.moneycare.tracking.incomes.repository

import com.moneycare.tracking.incomes.models.Tag
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
open class TagRepositoryBD : TagRepository {

    override fun findById(id: String): Optional<Tag> {
        println(id)
        return Optional.empty()
    }

}
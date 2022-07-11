package com.moneycare.tracking.incomes.repository

import com.moneycare.tracking.shared.models.Tag
import com.moneycare.tracking.shared.repository.TagRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
open class TagRepositoryBD : TagRepository {

    override fun findById(id: String): Optional<Tag> {
        println(id)
        return Optional.empty()
    }

}
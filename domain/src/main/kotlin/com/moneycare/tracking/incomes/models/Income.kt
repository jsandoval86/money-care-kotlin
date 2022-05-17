package com.moneycare.tracking.incomes.models

import com.moneycare.shared.messages.outbox.model.Message
import com.moneycare.tracking.incomes.valueobjects.Concept
import com.moneycare.tracking.incomes.valueobjects.Money
import java.time.LocalDateTime
import java.util.UUID

data class Income (
    var id : UUID,
    var concept: Concept,
    var amount : Money,
    var date : LocalDateTime,
    var tag : Tag
) {

    val messages: List<Message> = mutableListOf()

    companion object {

        fun create(concept: Concept, amount : Money, tag: Tag): Income {
            return create(UUID.randomUUID(), concept, amount, LocalDateTime.now(), tag)
        }

        fun create(id: UUID, concept: Concept, amount: Money, date: LocalDateTime, tag: Tag) : Income {
            // TODO(create event income created)
            return Income(id = id, concept = concept, amount = amount, date = date, tag = tag)
        }

    }

}

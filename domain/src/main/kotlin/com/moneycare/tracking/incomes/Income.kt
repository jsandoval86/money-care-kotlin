package com.moneycare.tracking.incomes

import com.moneycare.shared.messages.outbox.model.Message
import com.moneycare.tracking.shared.valueobjects.Concept
import com.moneycare.tracking.shared.valueobjects.Money
import java.time.LocalDateTime
import java.util.UUID

data class Income (
    var id : UUID,
    var concept: Concept,
    var amount : Money,
    var date : LocalDateTime,
    var tagId : String
) {

    val messages: MutableList<Message> = mutableListOf()

    companion object {

        fun create(concept: Concept, amount : Money, tagId: String): Income {
            val newIncome = create(UUID.randomUUID(), concept, amount, LocalDateTime.now(), tagId)
            newIncome.create()
            return newIncome
        }

        private fun create(id: UUID, concept: Concept, amount: Money, date: LocalDateTime, tagId: String) : Income {
            return Income(id = id, concept = concept, amount = amount, date = date, tagId = tagId)
        }

    }

    private fun create() {
        messages.add(
            IncomeCreatedEvent(this.id)
        )
    }
}

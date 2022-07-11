package com.moneycare.tracking.expenses

import com.moneycare.shared.messages.outbox.model.Message
import com.moneycare.tracking.shared.valueobjects.Concept
import com.moneycare.tracking.shared.valueobjects.Money
import java.time.LocalDateTime
import java.util.UUID

data class Expense(
  val id: UUID,
  val concept: Concept,
  val amount : Money,
  val date : LocalDateTime,
  val tagId : String
) {

  val messages : MutableList<Message> = mutableListOf()

  companion object {

    fun create(concept: Concept, amount: Money, tagId: String) : Expense {
      val newExpense = create(UUID.randomUUID(), concept, amount, LocalDateTime.now(), tagId)
      newExpense.create()
      return newExpense
    }

    fun create(id: UUID, concept: Concept, amount: Money, date: LocalDateTime, tagId: String) : Expense {
      return Expense(id = id, concept = concept, amount = amount, date = date, tagId = tagId)
    }

  }

  private fun create() {
    messages.add(
      ExpenseCreatedEvent(this.id)
    )
  }

}

package com.moneycare.tracking.expenses

import com.moneycare.shared.messages.outbox.model.Event
import java.util.UUID

class ExpenseCreatedEvent constructor(
    val id : UUID
): Event() {

    override var version = 1
    override fun type() : String {
        return "moneycare.tracking.$version.$messageType.expense.created"
    }
}
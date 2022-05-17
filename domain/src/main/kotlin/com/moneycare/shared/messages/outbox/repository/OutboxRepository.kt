package com.moneycare.shared.messages.outbox.repository

import com.moneycare.shared.messages.outbox.model.Message

interface OutboxRepository {
    fun save(message: Message)
    fun save(messages : List<Message>)
}
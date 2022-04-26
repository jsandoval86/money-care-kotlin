package com.moneycare.shared.messages.outbox.repository

interface OutboxRepository {
    fun save(message: Message)
}
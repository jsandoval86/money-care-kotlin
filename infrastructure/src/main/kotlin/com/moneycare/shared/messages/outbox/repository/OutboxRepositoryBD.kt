package com.moneycare.shared.messages.outbox.repository

import com.moneycare.shared.messages.outbox.model.Message
import org.springframework.stereotype.Repository

@Repository
open class OutboxRepositoryBD : OutboxRepository{

    override fun save(message: Message) {
        println(message)
    }

    override fun save(messages: List<Message>) {
        println(messages)
    }

}
package com.moneycare.shared.model

import com.moneycare.shared.messages.outbox.model.Message

open class Aggregate {

    val messages: MutableList<Message> = mutableListOf()

}
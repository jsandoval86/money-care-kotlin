package com.moneycare.shared.messages.outbox.model

import java.time.LocalDateTime

abstract class Event : Message() {
    override var messageType = "event"
    val date : LocalDateTime = LocalDateTime.now()
}
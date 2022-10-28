package com.moneycare.shared.messages.outbox.model

abstract class Message  {
    abstract var version : Int
    abstract var messageType : String
    var metadata : MutableMap<String, Any> = mutableMapOf()

    abstract fun type() : String

}
package com.moneycare.tracking.tags

data class CreateTagCommand constructor(
   private var name: String,
   private var type: TagType
) {

    fun getName() : String = name
    fun getType() : TagType = type
}
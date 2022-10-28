package com.moneycare.shared.helpers

import com.moneycare.tracking.tags.TagType

object EnumHelperError {

    private val map: MutableMap<String, String> = hashMapOf()
    private val message = "value should be:"

    init {
        map["TagType"] = "$message [${TagType.getNames()}]"
    }

    fun getError(key: String): String {
        val className = key.split(".").last()
        return map[className] ?: "no found values for $key"
    }

}


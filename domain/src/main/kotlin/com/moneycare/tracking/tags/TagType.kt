package com.moneycare.tracking.tags


enum class TagType {
    income, expense, no_type;

    companion object{
        fun getNames(): String {
            val names: StringBuilder = StringBuilder()
            for (n in values()) {
                names.append("$n, ")
            }
            return names.toString()
        }
    }
}
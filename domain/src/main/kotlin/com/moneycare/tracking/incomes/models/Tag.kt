package com.moneycare.tracking.incomes.models

data class Tag (
    var id : String,
    var tag : String
){

    companion object {

        fun create(id : String, tag : String) : Tag {
            return Tag(id = id, tag = tag)
        }

        fun withotTag() : Tag {
            // TODO(define without tag values)
            return Tag(id = "", tag = "")
        }

    }

}
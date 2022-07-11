package com.moneycare.tracking.shared.models

data class Tag (
    var id : String,
    var tag : String
){

    companion object {

        fun create(id : String, tag : String) : Tag {
            return Tag(id = id, tag = tag)
        }

        fun byDefault() : Tag {
            return Tag(id = "0000", tag = "no tag")
        }

    }

}
package com.moneycare.tracking.shared.valueobjects

data class Concept(
    var description : String
) {

    init {

        if( description.trim().isEmpty() ){
            description = "No description income"
        }

    }

}
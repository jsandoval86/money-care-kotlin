package com.moneycare.shared.exceptions

class TechnicalException : RuntimeException {

    constructor(message : String) : super(message)

    constructor(message: String?, cause: Throwable?) : super(message, cause)

}
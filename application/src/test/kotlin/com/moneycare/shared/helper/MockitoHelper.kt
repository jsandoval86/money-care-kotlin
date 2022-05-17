package com.moneycare.shared.helper

import org.mockito.Mockito

object MockitoHelper {

    fun <T> anyObject(): T {
        Mockito.any<T>()
        return uninitialized()
    }

    fun <T> anyList() : List<T> {
        Mockito.any<List<T>>()
        return uninitialized()
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> uninitialized(): T = null as T


}
package net.ntworld.kotlin.validator

interface Rule<T> {
    val message: String

    fun passes(attribute: String, value: T?): Boolean
}
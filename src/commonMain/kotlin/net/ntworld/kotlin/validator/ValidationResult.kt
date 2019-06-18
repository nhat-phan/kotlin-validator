package net.ntworld.kotlin.validator

interface ValidationResult {
    val isValid: Boolean

    val errors: MessageBag
}
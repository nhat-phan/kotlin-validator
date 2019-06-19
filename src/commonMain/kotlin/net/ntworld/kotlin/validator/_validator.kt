package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.exception.ValidationException
import net.ntworld.kotlin.validator.internal.ValidatorImpl

fun <T> validator(block: ValidatorRules<T>.() -> Unit): Validator<T> {
    return ValidatorImpl(block)
}

fun <T> validate(input: T, block: ValidatorRules<T>.() -> Unit): ValidationResult {
    return ValidatorImpl(block).validate(input)
}

fun <T> assertValid(input: T, block: ValidatorRules<T>.() -> Unit) {
    val result = validate(input, block)
    if (!result.isValid) {
        throw ValidationException(result.errors)
    }
}
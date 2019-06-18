package net.ntworld.kotlin.validator

interface Validator<T> {
    fun validate(input: T): ValidationResult

    fun extend(validator: Validator<in T>): Validator<T>

    operator fun plus(validator: Validator<in T>): Validator<T> = extend(validator)
}
package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.exception.ValidationException
import net.ntworld.kotlin.validator.internal.RuleCollectionImpl
import net.ntworld.kotlin.validator.internal.ValidatorImpl
import net.ntworld.kotlin.validator.rule.ArraySize
import net.ntworld.kotlin.validator.rule.Optional

infix fun <T : Any> Rule<T>.and(rule: Rule<T>): Rule<T> {
    if (this is RuleCollectionImpl<T>) {
        return this.addRule(rule)
    }

    if (rule is RuleCollectionImpl<T>) {
        return rule.addRule(this)
    }

    return RuleCollectionImpl<T>(Optional()).addRule(this).addRule(rule)
}

operator fun <T : Any> Rule<T>.plus(rule: Rule<T>): Rule<T> {
    return this.and(rule)
}

fun <T : Validatable> T.validatedBy(validator: Validator<T>): ValidationResult {
    return validator.validate(this)
}

fun <T : Validatable> T.validate(block: ValidatorRules<in T>.() -> Unit): ValidationResult {
    return ValidatorImpl(block).validate(this)
}

infix fun <T : Validatable> T.assert(validator: Validator<T>): T {
    val result = validator.validate(this)
    if (!result.isValid) {
        throw ValidationException(result.errors)
    }
    return this
}

infix fun <T : Validatable> T.assert(block: ValidatorRules<T>.() -> Unit): T {
    val result = ValidatorImpl(block).validate(this)
    if (!result.isValid) {
        throw ValidationException(result.errors)
    }
    return this
}

inline fun <reified T : Any> ValidatorRules<*>.maxSize(value: Int): Rule<T> {
    return ArraySize.lte(value = value)
}

inline fun <reified T : Any> ValidatorRules<*>.minSize(value: Int): Rule<T> {
    return ArraySize.gte(value = value)
}

inline fun <reified T : Any> ValidatorRules<*>.exactSize(value: Int): Rule<T> {
    return ArraySize.eq(value = value)
}
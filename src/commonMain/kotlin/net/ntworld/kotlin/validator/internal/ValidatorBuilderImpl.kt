package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.Rule
import net.ntworld.kotlin.validator.RuleBuilder
import net.ntworld.kotlin.validator.Validator
import net.ntworld.kotlin.validator.ValidatorBuilder
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class ValidatorBuilderImpl<T>(private val validator: ValidatorImpl<T>) : ValidatorBuilder<T> {
    override fun extend(validator: Validator<in T>): ValidatorBuilder<T> {
        this.validator.extend(validator)
        return this
    }

    override fun <R> KProperty0<R?>.always(rule: Rule<Any>): RuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty(this, builder.ruleCollection)
        return builder
    }

    override fun <R> KProperty1<T, R?>.always(rule: Rule<Any>): RuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty(this, builder.ruleCollection)
        return builder
    }
}



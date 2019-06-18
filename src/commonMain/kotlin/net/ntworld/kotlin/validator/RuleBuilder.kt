package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.rule.Optional
import net.ntworld.kotlin.validator.rule.Required
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

interface RuleBuilder<T> {
    var rule: Rule<T>

    var message: String

    infix fun and(rule: Rule<T>): RuleBuilder<T>

    @RuleBuilderDsl
    infix fun customMessage(message: String)

    @RuleBuilderDsl
    infix fun otherwise(message: String) = customMessage(message)

    // KProperty0 ----------------------------------------------------
    @RuleBuilderDsl
    infix fun <R> KProperty0<R?>.always(rule: Rule<Any>): RuleBuilder<R>

    @RuleBuilderDsl
    operator fun <R> KProperty0<R?>.invoke(block: RuleBuilder<R>.() -> Unit) {
        this.always(Optional()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R> KProperty0<R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R> KProperty0<R?>.required(rule: Rule<R>): RuleBuilder<R> {
        return this.always(Required()).and(rule)
    }

    // KProperty1 ----------------------------------------------------
    @RuleBuilderDsl
    infix fun <R> KProperty1<T, R?>.always(rule: Rule<Any>): RuleBuilder<R>

    @RuleBuilderDsl
    operator fun <R> KProperty1<T, R?>.invoke(block: RuleBuilder<R>.() -> Unit) {
        this.always(Optional()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R> KProperty1<T, R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R> KProperty1<T, R?>.required(rule: Rule<R>): RuleBuilder<R> {
        return this.always(Required()).and(rule)
    }
}
package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.Rule
import net.ntworld.kotlin.validator.RuleBuilder
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class RuleBuilderImpl<T>(started: Rule<Any>) : RuleBuilder<T> {
    internal val ruleCollection = RuleCollectionImpl<T>(started)

    override var rule: Rule<T>
        get() = ruleCollection
        set(value) {
            ruleCollection.addRule(value)
        }

    override var message: String
        get() = ruleCollection.message
        set(value) {
            ruleCollection.customMessage = value
        }

    override fun and(rule: Rule<T>): RuleBuilder<T> {
        ruleCollection.addRule(rule)

        return this
    }

    override fun customMessage(message: String) {
        this.message = message
    }

    override fun <R> KProperty0<R?>.always(rule: Rule<Any>): RuleBuilder<R> {
        val validator = ValidatorImpl<T> {}
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty(this, builder.ruleCollection)
        this@RuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }

    override fun <R> KProperty1<T, R?>.always(rule: Rule<Any>): RuleBuilder<R> {
        val validator = ValidatorImpl<T> {}
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty(this, builder.ruleCollection)
        this@RuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }
}
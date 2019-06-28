package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.rule.Skipped
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class RuleBuilderImpl<T>(premierRule: PremierRule, usingOr: Boolean = false) : NestedRuleBuilder<T> {
    internal val ruleCollection = RuleCollectionImpl<T>(premierRule, usingOr)

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

    override fun customMessage(message: String) {
        this.message = message
    }

    override fun and(rule: Rule<T>): AlwaysRuleBuilder<T> {
        ruleCollection.addRule(rule)

        return this
    }

    override fun <R : Any> KProperty0<R?>.invoke(block: NestedRuleBuilder<R>.() -> Unit) {
        (this.always(Skipped()) as RuleBuilderImpl<R>).apply(block)
    }

    override fun <R : Any> KProperty1<T, R?>.invoke(block: NestedRuleBuilder<R>.() -> Unit) {
        (this.always(Skipped()) as RuleBuilderImpl<R>).apply(block)
    }

    override fun <R> KProperty0<R?>.always(rule: AlwaysPremierRule): AlwaysRuleBuilder<R> {
        val validator = ValidatorImpl<T> {}
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty0(this, builder.ruleCollection)
        this@RuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }

    override fun <R> KProperty1<T, R?>.always(rule: AlwaysPremierRule): AlwaysRuleBuilder<R> {
        val validator = ValidatorImpl<T> {}
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty1(this, builder.ruleCollection)
        this@RuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }

    override fun or(rule: Rule<T>): WhetherRuleBuilder<T> {
        ruleCollection.addRule(rule, false)

        return this
    }

    override fun <R> KProperty0<R?>.whether(rule: WhetherPremierRule): WhetherRuleBuilder<R> {
        val validator = ValidatorImpl<T> {}
        val builder = RuleBuilderImpl<R>(rule, true)
        validator.registerProperty0(this, builder.ruleCollection)
        this@RuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }

    override fun <R> KProperty1<T, R?>.whether(rule: WhetherPremierRule): WhetherRuleBuilder<R> {
        val validator = ValidatorImpl<T> {}
        val builder = RuleBuilderImpl<R>(rule, true)
        validator.registerProperty1(this, builder.ruleCollection)
        this@RuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }
}
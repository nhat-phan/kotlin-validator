package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.*
import net.ntworld.kotlin.validator.rule.Skipped
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class ValidatorRulesImpl<T>(private val validator: ValidatorImpl<T>) : ValidatorRules<T> {
    override fun extend(validator: Validator<in T>): ValidatorRules<T> {
        this.validator.extend(validator)
        return this
    }

    override fun <R : Any> KProperty0<R?>.invoke(block: NestedRuleBuilder<R>.() -> Unit) {
        (this.always(Skipped()) as RuleBuilderImpl<R>).apply(block)
    }

    override fun <R : Any> KProperty1<T, R?>.invoke(block: NestedRuleBuilder<R>.() -> Unit) {
        (this.always(Skipped()) as RuleBuilderImpl<R>).apply(block)
    }

    override fun <R> KProperty0<R?>.always(rule: AlwaysPremierRule): AlwaysRuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty0(this, builder.ruleCollection)
        return builder
    }

    override fun <R> KProperty1<T, R?>.always(rule: AlwaysPremierRule): AlwaysRuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty1(this, builder.ruleCollection)
        return builder
    }

    override fun <R> KProperty0<R?>.whether(rule: WhetherPremierRule): WhetherRuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule, true)
        validator.registerProperty0(this, builder.ruleCollection)
        return builder
    }

    override fun <R> KProperty1<T, R?>.whether(rule: WhetherPremierRule): WhetherRuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule, true)
        validator.registerProperty1(this, builder.ruleCollection)
        return builder
    }
}



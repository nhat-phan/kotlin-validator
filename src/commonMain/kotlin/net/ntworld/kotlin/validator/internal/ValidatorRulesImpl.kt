package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.*
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class ValidatorRulesImpl<T>(private val validator: ValidatorImpl<T>) : ValidatorRules<T> {
    override fun extend(validator: Validator<in T>): ValidatorRules<T> {
        this.validator.extend(validator)
        return this
    }

    override fun <R> KProperty0<R?>.always(rule: PremierRule): RuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty0(this, builder.ruleCollection)
        return builder
    }

    override fun <R> KProperty1<T, R?>.always(rule: PremierRule): RuleBuilder<R> {
        val builder = RuleBuilderImpl<R>(rule)
        validator.registerProperty1(this, builder.ruleCollection)
        return builder
    }
}



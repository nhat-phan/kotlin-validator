package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.AlwaysRuleBuilder
import net.ntworld.kotlin.validator.PremierRule
import net.ntworld.kotlin.validator.Rule
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal class AlwaysRuleBuilderImpl<T>(premierRule: PremierRule): RuleBuilderImpl<T>(premierRule), AlwaysRuleBuilder<T> {
    override fun and(rule: Rule<T>): AlwaysRuleBuilder<T> {
        ruleCollection.addRule(rule)

        return this
    }

    override fun <R> KProperty0<R?>.always(rule: PremierRule): AlwaysRuleBuilder<R> {
        val validator = ValidatorImpl<T> {}
        val builder = AlwaysRuleBuilderImpl<R>(rule)
        validator.registerProperty0(this, builder.ruleCollection)
        this@AlwaysRuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }

    override fun <R> KProperty1<T, R?>.always(rule: PremierRule): AlwaysRuleBuilder<R> {
        val validator = ValidatorImpl<T> {}
        val builder = AlwaysRuleBuilderImpl<R>(rule)
        validator.registerProperty1(this, builder.ruleCollection)
        this@AlwaysRuleBuilderImpl.ruleCollection.addRule(validator)

        return builder
    }
}
package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.rule.Each
import net.ntworld.kotlin.validator.rule.Skipped
import net.ntworld.kotlin.validator.rule.Required
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

interface AlwaysRuleBuilder<T>: RuleBuilder<T> {
    infix fun and(rule: Rule<T>): AlwaysRuleBuilder<T>

    // KProperty0 ----------------------------------------------------
    @RuleBuilderDsl
    infix fun <R> KProperty0<R?>.always(rule: AlwaysPremierRule): AlwaysRuleBuilder<R>

    @RuleBuilderDsl
    operator fun <R: Any> KProperty0<R?>.invoke(block: AlwaysRuleBuilder<R>.() -> Unit) {
        this.always(Skipped()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R: Any> KProperty0<R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R: Any> KProperty0<R?>.required(rule: Rule<R>): AlwaysRuleBuilder<R> {
        return this.always(Required()).and(rule)
    }

    // KProperty1 ----------------------------------------------------
    @RuleBuilderDsl
    infix fun <R> KProperty1<T, R?>.always(rule: AlwaysPremierRule): AlwaysRuleBuilder<R>

    @RuleBuilderDsl
    operator fun <R: Any> KProperty1<T, R?>.invoke(block: AlwaysRuleBuilder<R>.() -> Unit) {
        this.always(Skipped()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R: Any> KProperty1<T, R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R: Any> KProperty1<T, R?>.required(rule: Rule<R>): AlwaysRuleBuilder<R> {
        return this.always(Required()).and(rule)
    }
}
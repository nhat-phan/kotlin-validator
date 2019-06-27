package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.rule.Skipped
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

interface WhetherRuleBuilder<T>: RuleBuilder<T> {
    infix fun or(rule: Rule<T>): WhetherRuleBuilder<T>

    // KProperty0 ----------------------------------------------------
    @RuleBuilderDsl
    infix fun <R> KProperty0<R?>.whether(rule: WhetherPremierRule): WhetherRuleBuilder<R>

    @RuleBuilderDsl
    infix fun <R: Any> KProperty0<R?>.optional(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.whether(Skipped()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R: Any> KProperty0<R?>.optional(rule: Rule<R>): WhetherRuleBuilder<R> {
        return this.whether(Skipped()).or(rule)
    }

    // KProperty1 ----------------------------------------------------
    @RuleBuilderDsl
    infix fun <R> KProperty1<T, R?>.whether(rule: WhetherPremierRule): WhetherRuleBuilder<R>

    @RuleBuilderDsl
    infix fun <R: Any> KProperty1<T, R?>.optional(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.whether(Skipped()).apply(block)
    }

    @RuleBuilderDsl
    infix fun <R: Any> KProperty1<T, R?>.optional(rule: Rule<R>): WhetherRuleBuilder<R> {
        return this.whether(Skipped()).or(rule)
    }
}
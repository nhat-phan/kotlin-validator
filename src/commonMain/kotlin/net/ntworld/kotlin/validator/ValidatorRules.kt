package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.rule.Each
import net.ntworld.kotlin.validator.rule.Skipped
import net.ntworld.kotlin.validator.rule.Required
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

@ValidatorRulesDsl
interface ValidatorRules<T>: BuiltinRules {
    // Builder feature ----------------------------------------------------
    @ValidatorRulesDsl
    infix fun extend(validator: Validator<in T>): ValidatorRules<T>

    // stopAtFirstError() -> not implemented yet.

    // KProperty0 ----------------------------------------------------
    @ValidatorRulesDsl
    operator fun <R: Any> KProperty0<R?>.invoke(block: NestedRuleBuilder<R>.() -> Unit)

    @ValidatorRulesDsl
    infix fun <R> KProperty0<R?>.always(rule: AlwaysPremierRule): AlwaysRuleBuilder<R>

    @ValidatorRulesDsl
    infix fun <R: Any> KProperty0<R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @ValidatorRulesDsl
    infix fun <R: Any> KProperty0<R?>.required(rule: Rule<R>): AlwaysRuleBuilder<R> {
        return this.always(Required()).and(rule)
    }

    @ValidatorRulesDsl
    infix fun <E, R : Collection<E?>> KProperty0<R?>.each(rule: Rule<E>): RuleBuilder<R> {
        return this.always(Skipped()).and(Each(rule))
    }

    // KProperty1 ----------------------------------------------------
    @ValidatorRulesDsl
    operator fun <R: Any> KProperty1<T, R?>.invoke(block: NestedRuleBuilder<R>.() -> Unit)

    @ValidatorRulesDsl
    infix fun <R> KProperty1<T, R?>.always(rule: AlwaysPremierRule): AlwaysRuleBuilder<R>

    @ValidatorRulesDsl
    infix fun <R: Any> KProperty1<T, R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @ValidatorRulesDsl
    infix fun <R: Any> KProperty1<T, R?>.required(rule: Rule<R>): AlwaysRuleBuilder<R> {
        return this.always(Required()).and(rule)
    }

    @ValidatorRulesDsl
    infix fun <E, R : Collection<E?>> KProperty1<T, R?>.each(rule: Rule<E>): RuleBuilder<R> {
        return this.always(Skipped()).and(Each(rule))
    }
}

package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.rule.Each
import net.ntworld.kotlin.validator.rule.Optional
import net.ntworld.kotlin.validator.rule.Required
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

@ValidatorRulesDsl
interface ValidatorRules<T>: BuiltinRules {
    // Builder feature ----------------------------------------------------
    @ValidatorRulesDsl
    infix fun extend(validator: Validator<in T>): ValidatorRules<T>

    @ValidatorRulesDsl
    infix fun use(validator: Validator<T>): ValidatorRules<T> = extend(validator)

    @ValidatorRulesDsl
    infix fun run(validator: Validator<T>): ValidatorRules<T> = extend(validator)

    // stopAtFirstError() -> not implemented yet.

    // KProperty0 ----------------------------------------------------
    @ValidatorRulesDsl
    infix fun <R> KProperty0<R?>.always(rule: Rule<Any>): RuleBuilder<R>

    @ValidatorRulesDsl
    operator fun <R> KProperty0<R?>.invoke(block: RuleBuilder<R>.() -> Unit) {
        this.always(Optional()).apply(block)
    }

    @ValidatorRulesDsl
    infix fun <R> KProperty0<R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @ValidatorRulesDsl
    infix fun <R> KProperty0<R?>.required(rule: Rule<R>): RuleBuilder<R> {
        return this.always(Required()).and(rule)
    }

    @ValidatorRulesDsl
    infix fun <E, R : Collection<E?>> KProperty0<R?>.each(rule: Rule<E>): RuleBuilder<R> {
        return this.always(Optional()).and(Each(rule))
    }

    // KProperty1 ----------------------------------------------------
    @ValidatorRulesDsl
    infix fun <R> KProperty1<T, R?>.always(rule: Rule<Any>): RuleBuilder<R>

    @ValidatorRulesDsl
    operator fun <R> KProperty1<T, R?>.invoke(block: RuleBuilder<R>.() -> Unit) {
        this.always(Optional()).apply(block)
    }

    @ValidatorRulesDsl
    infix fun <R> KProperty1<T, R?>.required(block: RuleBuilder<R>.() -> Unit): RuleBuilder<R> {
        return this.always(Required()).apply(block)
    }

    @ValidatorRulesDsl
    infix fun <R> KProperty1<T, R?>.required(rule: Rule<R>): RuleBuilder<R> {
        return this.always(Required()).and(rule)
    }

    @ValidatorRulesDsl
    infix fun <E, R : Collection<E?>> KProperty1<T, R?>.each(rule: Rule<E>): RuleBuilder<R> {
        return this.always(Optional()).and(Each(rule))
    }
}

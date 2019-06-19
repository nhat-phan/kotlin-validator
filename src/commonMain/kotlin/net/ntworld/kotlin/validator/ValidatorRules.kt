package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.internal.RuleFactory
import net.ntworld.kotlin.validator.rule.*
import net.ntworld.kotlin.validator.rule.NumberComparison
import net.ntworld.kotlin.validator.rule.Optional
import net.ntworld.kotlin.validator.rule.Required
import net.ntworld.kotlin.validator.rule.StringLength
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

@ValidatorRulesDsl
interface ValidatorRules<T> {
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

    // Builtin rules -------------------------------------------------

    @RuleDsl
    val exists: Rule<Any>
        get() = RuleFactory.notNull

    @RuleDsl
    val required: Rule<Any>
        get() = RuleFactory.required

    @RuleDsl
    val notNull: Rule<Any>
        get() = RuleFactory.notNull

    @RuleDsl
    val notEmptyString: Rule<String>
        get() = RuleFactory.notEmptyString

    @RuleDsl
    infix fun <V> pass(fn: (V?) -> Boolean): Rule<V> = Pass(fn)

    @RuleDsl
    infix fun <V> passes(fn: (V?) -> Boolean): Rule<V> = pass(fn)

    @RuleDsl
    fun <V> eq(value: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_EQUAL, value)

    @RuleDsl
    fun <V> equal(value: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_EQUAL, value)

    @RuleDsl
    fun <V> gt(min: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_GREATER_THAN, min)

    @RuleDsl
    fun <V> greaterThan(min: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_GREATER_THAN, min)

    @RuleDsl
    fun <V> gte(min: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_GREATER_THAN_OR_EQUAL, min)

    @RuleDsl
    fun <V> greaterThanOrEqual(min: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_GREATER_THAN_OR_EQUAL, min)

    @RuleDsl
    fun <V> lt(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_LESS_THAN, max)

    @RuleDsl
    fun <V> lessThan(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_LESS_THAN, max)

    @RuleDsl
    fun <V> lte(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_LESS_THAN_OR_EQUAL, max)

    @RuleDsl
    fun <V> lessThanOrEqual(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_LESS_THAN_OR_EQUAL, max)

    @RuleDsl
    fun minLength(value: Int): Rule<String> = StringLength(OPERATOR_GREATER_THAN_OR_EQUAL, value)

    @RuleDsl
    fun maxLength(value: Int): Rule<String> = StringLength(OPERATOR_LESS_THAN_OR_EQUAL, value)

    @RuleDsl
    fun exactLength(value: Int): Rule<String> = StringLength(OPERATOR_LESS_THAN_OR_EQUAL, value)

    @RuleDsl
    fun <V : CharSequence> passRegex(pattern: String): Rule<V> = PassRegex(kotlin.text.Regex(pattern))

    @RuleDsl
    fun <V : CharSequence> passRegex(pattern: String, option: RegexOption): Rule<V> = PassRegex(Regex(pattern, option))

    @RuleDsl
    fun <V : CharSequence> passRegex(pattern: String, option: Set<RegexOption>): Rule<V> =
        PassRegex(Regex(pattern, option))

    @RuleDsl
    fun <V : CharSequence> matches(pattern: String): Rule<V> = passRegex(pattern)

    @RuleDsl
    fun <V : CharSequence> matches(pattern: String, option: RegexOption): Rule<V> = passRegex(pattern, option)

    @RuleDsl
    fun <V : CharSequence> matches(pattern: String, option: Set<RegexOption>): Rule<V> = passRegex(pattern, option)

    @RuleDsl
    infix fun <E, V : Collection<E?>> each(rule: Rule<E>): Rule<V> = Each(rule)

}

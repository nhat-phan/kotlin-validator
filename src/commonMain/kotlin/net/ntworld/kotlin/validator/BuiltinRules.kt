package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.internal.RuleFactory
import net.ntworld.kotlin.validator.rule.Each
import net.ntworld.kotlin.validator.rule.NumberComparison
import net.ntworld.kotlin.validator.rule.Pass
import net.ntworld.kotlin.validator.rule.PassRegex
import net.ntworld.kotlin.validator.rule.StringLength

interface BuiltinRules {
    @RuleDsl
    val exists: AlwaysPremierRule
        get() = RuleFactory.notNull

    @RuleDsl
    val required: AlwaysPremierRule
        get() = RuleFactory.required

    @RuleDsl
    val notNull: AlwaysPremierRule
        get() = RuleFactory.notNull

    @RuleDsl
    val isNull: WhetherPremierRule
        get() = RuleFactory.isNull

    @RuleDsl
    val notEmptyString: Rule<String>
        get() = RuleFactory.notEmptyString

    @RuleDsl
    infix fun <V> pass(fn: (V?) -> Boolean): Rule<V> = Pass(fn)

    @RuleDsl
    infix fun <V> passes(fn: (V?) -> Boolean): Rule<V> = pass(fn)

    @RuleDsl
    fun <V> eq(value: V): Rule<V> where V : Number, V : Comparable<V> = NumberComparison(OPERATOR_EQUAL, value)

    @RuleDsl
    fun <V> equal(value: V): Rule<V> where V : Number, V : Comparable<V> = eq(value)

    @RuleDsl
    fun <V> gt(min: V): Rule<V> where V : Number, V : Comparable<V> = NumberComparison(OPERATOR_GREATER_THAN, min)

    @RuleDsl
    fun <V> greaterThan(min: V): Rule<V> where V : Number, V : Comparable<V> = gt(min)

    @RuleDsl
    fun <V> gte(min: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_GREATER_THAN_OR_EQUAL, min)

    @RuleDsl
    fun <V> greaterThanOrEqual(min: V): Rule<V> where V : Number, V : Comparable<V> = gte(min)

    @RuleDsl
    fun <V> lt(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_LESS_THAN, max)

    @RuleDsl
    fun <V> lessThan(max: V): Rule<V> where V : Number, V : Comparable<V> = lt(max)

    @RuleDsl
    fun <V> lte(max: V): Rule<V> where V : Number, V : Comparable<V> =
        NumberComparison(OPERATOR_LESS_THAN_OR_EQUAL, max)

    @RuleDsl
    fun <V> lessThanOrEqual(max: V): Rule<V> where V : Number, V : Comparable<V> = lte(max)

    @RuleDsl
    fun minLength(value: Int): Rule<String> = StringLength(OPERATOR_GREATER_THAN_OR_EQUAL, value)

    @RuleDsl
    fun maxLength(value: Int): Rule<String> = StringLength(OPERATOR_LESS_THAN_OR_EQUAL, value)

    @RuleDsl
    fun exactLength(value: Int): Rule<String> = StringLength(OPERATOR_LESS_THAN_OR_EQUAL, value)

    @RuleDsl
    fun <V : CharSequence> passRegex(pattern: String): Rule<V> = PassRegex(Regex(pattern))

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
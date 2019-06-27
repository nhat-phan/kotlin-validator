package net.ntworld.kotlin.validator

import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

interface NestedRuleBuilder<T>: AlwaysRuleBuilder<T>, WhetherRuleBuilder<T> {
    operator fun <R: Any> KProperty0<R?>.invoke(block: NestedRuleBuilder<R>.() -> Unit)

    operator fun <R: Any> KProperty1<T, R?>.invoke(block: NestedRuleBuilder<R>.() -> Unit)
}
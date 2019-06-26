package net.ntworld.kotlin.validator

import net.ntworld.kotlin.validator.rule.Optional
import net.ntworld.kotlin.validator.rule.Required
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

interface RuleBuilder<T> {
    var rule: Rule<T>

    var message: String

    @RuleBuilderDsl
    infix fun customMessage(message: String)

    @RuleBuilderDsl
    infix fun customMessage(block: () -> String) = customMessage(block.invoke())

    @RuleBuilderDsl
    infix fun otherwise(message: String) = customMessage(message)

    @RuleBuilderDsl
    infix fun otherwise(block: () -> String) = customMessage(block)
}
package net.ntworld.kotlin.validator

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
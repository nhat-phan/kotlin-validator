package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.Rule
import net.ntworld.kotlin.validator.PremierRule
import net.ntworld.kotlin.validator.RuleBuilder
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1

internal open class RuleBuilderImpl<T>(premierRule: PremierRule) : RuleBuilder<T> {
    internal val ruleCollection = RuleCollectionImpl<T>(premierRule)

    override var rule: Rule<T>
        get() = ruleCollection
        set(value) {
            ruleCollection.addRule(value)
        }

    override var message: String
        get() = ruleCollection.message
        set(value) {
            ruleCollection.customMessage = value
        }

    override fun customMessage(message: String) {
        this.message = message
    }
}
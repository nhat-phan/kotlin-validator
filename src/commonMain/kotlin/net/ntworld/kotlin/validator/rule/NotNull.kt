package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.AlwaysPremierRule
import net.ntworld.kotlin.validator.MESSAGE_NOT_NULL

internal class NotNull : AlwaysPremierRule {
    override val message: String = MESSAGE_NOT_NULL

    override fun passes(attribute: String, value: Any?): Boolean {
        return null !== value
    }
}
package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_OPTIONAL
import net.ntworld.kotlin.validator.PremierRule

internal class Optional : PremierRule {
    override val message: String = MESSAGE_OPTIONAL

    override fun passes(attribute: String, value: Any?): Boolean {
        return true
    }
}
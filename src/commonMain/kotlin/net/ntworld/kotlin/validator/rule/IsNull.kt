package net.ntworld.kotlin.validator.rule

import net.ntworld.kotlin.validator.MESSAGE_IS_NULL
import net.ntworld.kotlin.validator.WhetherPremierRule

internal class IsNull : WhetherPremierRule {
    override val message: String = MESSAGE_IS_NULL

    override fun passes(attribute: String, value: Any?): Boolean {
        return null === value
    }
}
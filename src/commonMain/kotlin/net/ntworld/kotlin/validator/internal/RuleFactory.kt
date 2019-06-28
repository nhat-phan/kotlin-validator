package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.rule.IsNull
import net.ntworld.kotlin.validator.rule.NotEmptyString
import net.ntworld.kotlin.validator.rule.NotNull
import net.ntworld.kotlin.validator.rule.Required

internal object RuleFactory {
    val isNull = IsNull()

    val notNull = NotNull()

    val required = Required()

    val notEmptyString = NotEmptyString()
}
package net.ntworld.kotlin.validator.exception

import net.ntworld.kotlin.validator.Rule

class IllegalTypeException(type: String, rule: Rule<*>) : IllegalArgumentException(
    "The type $type can not be validated by rule $rule"
)
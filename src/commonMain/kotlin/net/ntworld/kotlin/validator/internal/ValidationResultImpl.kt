package net.ntworld.kotlin.validator.internal

import net.ntworld.kotlin.validator.MessageBag
import net.ntworld.kotlin.validator.ValidationResult

internal data class ValidationResultImpl(override val isValid: Boolean, override val errors: MessageBag) : ValidationResult
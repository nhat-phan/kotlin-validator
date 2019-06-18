package net.ntworld.kotlin.validator.exception

import net.ntworld.kotlin.validator.MessageBag

class ValidationException(val errors: MessageBag) : Exception()
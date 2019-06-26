package net.ntworld.kotlin.validator

/**
 * There is no assertion because this file suppose to be failed at built-time if something go wrong!
 */
class FluentSyntaxTest {
    data class Address(
        val number: Float,
        val street: String
    ) : Validatable {
        override fun containsKey(key: String): Boolean {
            return true
        }
    }

    data class Document(
        val locations: List<String>?,
        val name: String
    ) : Validatable {
        override fun containsKey(key: String): Boolean {
            return true
        }
    }

    data class User(
        val email: String,
        val age: Int,
        val address: Address,
        val documents: List<Document>? = null
    ) : Validatable {
        override fun containsKey(key: String): Boolean {
            return true
        }
    }

    private val user = User("", 0, Address(0.0f, ""))

    fun always_required() {
        validator<User> {
            User::email always required
            User::documents always required
            User::documents each notNull
        }

        user.validate {
            user::email always required
        }

        validator<User> {
            User::email always required otherwise "this is custom message"
            User::age always required otherwise {
                "custom message via a function"
            }
        }

        user.validate {
            user::email always required otherwise "this is custom message"
            user::age always required otherwise {
                "custom message via a function"
            }
        }
    }

    fun always_required_and_rule() {
        validator<User> {
            User::email always required and passRegex("regex") otherwise "this is custom message"
            User::age always required and gt(10) otherwise {
                "custom message via a function"
            }
        }

        user.validate {
            user::email always required and passRegex("regex")
            user::age always required and gt(10) otherwise {
                "custom message via a function"
            }
        }
    }

    fun block() {
        validator<User> {
            User::email {
                rule = notEmptyString + minLength(10)
                message = "this is custom message"
            }
        }

        user.validate {
            user::email {
                rule = notEmptyString + minLength(10)
                message = "this is custom message"
            }
        }
    }

    fun always_required_block() {
        validator<User> {
            User::email required {
                rule = notEmptyString
                message = "this is custom message"
            }
        }

        user.validate {
            user::email required {
                rule = notEmptyString
                message = "this is custom message"
            }
        }
    }

    fun required_rule() {
        validator<User> {
            User::email required passRegex("regex") otherwise "this is custom message"
        }

        user.validate {
            user::email required passRegex("regex") otherwise "this is custom message"
        }
    }

    fun required_rule_and_rule() {
        validator<User> {
            User::email required notEmptyString and passRegex("regex") otherwise "this is custom message"
        }

        user.validate {
            user::email required notEmptyString and passRegex("regex") otherwise "this is custom message"
        }
    }

    fun nested_always_required() {
        validator<User> {
            User::address {
                Address::street always required otherwise "this is custom message"
            }
        }

        user.validate {
            user::address {
                Address::street always required otherwise "this is custom message"
            }
        }
    }

    fun nested_always_required_and_rule() {
        validator<User> {
            User::address {
                Address::street always required and passRegex("regex") otherwise "this is custom message"
            }
        }

        user.validate {
            user::address {
                Address::street always required and passRegex("regex") otherwise "this is custom message"
            }
        }
    }

    fun nested_block() {
        validator<User> {
            User::address {
                Address::street {
                    rule = notEmptyString
                    message = "this is custom message"
                }
            }
        }

        user.validate {
            user::address {
                Address::street {
                    rule = notEmptyString
                    message = "this is custom message"
                }
            }
        }
    }

    fun nested_required_block() {
        validator<User> {
            User::address {
                Address::street required {
                    rule = notEmptyString
                    message = "this is custom message"
                }
            }
        }

        user.validate {
            user::address {
                Address::street required {
                    rule = notEmptyString
                    message = "this is custom message"
                }
            }
        }
    }

    fun nested_required_rule() {
        validator<User> {
            User::address {
                Address::street required passRegex("regex") otherwise "this is custom message"
            }
        }

        user.validate {
            user::address {
                Address::street required passRegex("regex") otherwise "this is custom message"
            }
        }
    }

    fun nested_required_rule_and_rule() {
        validator<User> {
            User::address {
                Address::street required notEmptyString and passRegex("regex") otherwise "this is custom message"
            }
        }

        user.validate {
            user::address {
                Address::street required notEmptyString and passRegex("regex") otherwise "this is custom message"
            }
        }
    }

}
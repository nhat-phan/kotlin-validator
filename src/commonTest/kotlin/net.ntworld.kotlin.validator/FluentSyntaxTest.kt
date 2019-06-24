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

    data class User(
        val email: String,
        val age: Int,
        val address: Address
    ) : Validatable {
        override fun containsKey(key: String): Boolean {
            return true
        }
    }

    private val user = User("", 0, Address(0.0f, ""))

    fun always_required() {
        validator<User> {
            User::email always required
        }

        user.validate {
            user::email always required
        }
    }

    fun always_required_and_rule() {
        validator<User> {
            User::email always required and passRegex("regex")
        }

        user.validate {
            user::email always required and passRegex("regex")
        }
    }

    fun required_rule() {
        validator<User> {
            User::email required passRegex("regex")
        }

        user.validate {
            user::email required passRegex("regex")
        }
    }

    fun required_rule_and_rule() {
        validator<User> {
            User::email required notEmptyString and passRegex("regex")
        }

        user.validate {
            user::email required notEmptyString and passRegex("regex")
        }
    }

    fun nested_always_required() {
        validator<User> {
            User::address {
                Address::street always required
            }
        }

        user.validate {
            user::address {
                Address::street always required
            }
        }
    }

    fun nested_always_required_and_rule() {
        validator<User> {
            User::address {
                Address::street always required and passRegex("regex")
            }
        }

        user.validate {
            user::address {
                Address::street always required and passRegex("regex")
            }
        }
    }

    fun nested_required_rule() {
        validator<User> {
            User::address {
                Address::street required passRegex("regex")
            }
        }

        user.validate {
            user::address {
                Address::street required passRegex("regex")
            }
        }
    }

    fun nested_required_rule_and_rule() {
        validator<User> {
            User::address {
                Address::street required notEmptyString and passRegex("regex")
            }
        }

        user.validate {
            user::address {
                Address::street required notEmptyString and passRegex("regex")
            }
        }
    }

}
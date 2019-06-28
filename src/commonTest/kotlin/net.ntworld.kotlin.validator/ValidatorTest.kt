package net.ntworld.kotlin.validator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidatorTest {
    data class City(val name: String, val state: String)

    data class Address(val number: Int, val street: String, val city: City)

    data class User(
        val username: String?,
        val age: Int?,
        val address: Address
    )

    @Test
    fun testSyntax_String_Always_Required() {
        val validator = validator<User> {
            User::username always required
        }

        val dataset = listOf("", " ", "     ");
        dataset.onEach {
            val result = validator.validate(User(it, 0, Address(0, "", City("", ""))))
            assertFalse(result.isValid)
            assertTrue(result.errors.has("username"))
            assertEquals(result.errors.get("username"), setOf(MESSAGE_REQUIRED.replace(":attribute", "username")))
        }
    }

    @Test
    fun testSyntax_String_Required_NotEmptyString() {
        val validator = validator<User> {
            User::username required notEmptyString
        }

        val dataset = listOf("", " ", "     ");
        dataset.onEach {
            val result = validator.validate(User(it, 0, Address(0, "", City("", ""))))
            assertFalse(result.isValid)
            assertTrue(result.errors.has("username"))
            assertEquals(result.errors.get("username"), setOf(MESSAGE_REQUIRED.replace(":attribute", "username")))
        }
    }

    @Test
    fun testSyntax_String_Whether_IsNull() {
        val validator = validator<User> {
            // User::username whether isNull or notEmptyString
            User::age whether isNull or gte(1000) or (gt(10) and lt(100))
        }

        val dataset = listOf(null, 1001, 999, 5);
        // val dataset = listOf(999);
        dataset.onEach {
            val result = validator.validate(User("", it, Address(0, "", City("", ""))))
            println(result)
            if (it === null) {
                // assertTrue(result.isValid)
            } else {
                // assertFalse(result.isValid)
                // assertTrue(result.errors.has("username"))
                // assertEquals(result.errors.get("username"), setOf(MESSAGE_REQUIRED.replace(":attribute", "username")))
            }
        }
    }

    @Test
    fun testNestedField() {
        val validator = validator<User> {
            User::address {
                Address::city {
                    City::name always required
                }
            }
        }

        val user = User("", 0, Address(0, "", City("", "")))
        val result = validator.validate(user)
        assertFalse(result.isValid)
        assertEquals(
            result.errors.get("address.city.name"),
            setOf(MESSAGE_REQUIRED.replace(":attribute", "address.city.name"))
        )
    }
}
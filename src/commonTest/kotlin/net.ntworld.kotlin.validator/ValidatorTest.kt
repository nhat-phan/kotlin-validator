package net.ntworld.kotlin.validator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidatorTest {
    data class City(val name: String, val state: String)

    data class Address(val number: Int, val street: String, val city: City)

    data class User(
        val username: String,
        val age: Int,
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
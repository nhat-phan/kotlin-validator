package net.ntworld.kotlin.validator

import kotlin.test.Test

class ValidatorTest {
    @Test
    fun testSyntax() {
        data class Data(
            var name: String
        )

        val validator = validator<Data> {
            Data::name always required
        }
    }
}
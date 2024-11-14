package com.gilpereda.examples

import com.navercorp.fixturemonkey.FixtureMonkey
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeOne
import jakarta.validation.constraints.Size
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FixtureMonkeyBugTest {
    private val fixtureMonkey =
        FixtureMonkey
            .builder()
            .plugin(KotlinPlugin())
            .plugin(JakartaValidationPlugin())
            .build()

    class Example(
        @field:Size(min = 0, max = 0)
        val iShouldBeEmpty: String,
    )

    @Test
    fun `should generate an empty string`() {
        val example = fixtureMonkey.giveMeOne<Example>()

        assertThat(example.iShouldBeEmpty).isBlank()
    }
}

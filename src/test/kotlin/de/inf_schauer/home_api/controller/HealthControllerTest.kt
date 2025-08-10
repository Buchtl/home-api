package de.inf_schauer.home_api.controller

import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(HealthController::class)
class HealthControllerTest(
    @Autowired val mockMvc: MockMvc
) {

    @Test
    fun `should return healthy`() {
        mockMvc.get("/health") // send GET request
            .andExpect {
                status { isOk() } // HTTP 200
                content { string(equalTo("healthy")) } // exact body match
            }
    }
}

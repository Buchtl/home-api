package de.inf_schauer.home_api.controller

import de.inf_schauer.home_api.service.DbService
import de.inf_schauer.home_api.temp.TempResponse
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.eq
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import java.time.Instant

@WebMvcTest(TempController::class)
class TempControllerTest(@Autowired private val mockMvc: MockMvc) {
    @MockBean
    lateinit var service: DbService

    @Test
    fun `should call service to save`() {
        val device = "room_1"
        val value = 36.2f
        val timestamp = Instant.now()

        val response = TempResponse(device = device, value = value, timestamp = timestamp)

        whenever(service.save(any(), any(), any())).thenReturn(response)

        mockMvc.post(urlTemplate = "/temp") {
            contentType = MediaType.APPLICATION_JSON
            content = """{"device":"$device","value":$value,"timestamp":"$timestamp"}"""
        }.andExpect {
            status { isOk() }
        }.andExpect {
            content {
                json("""{"device":"$device","value":$value,  "timestamp":"$timestamp"} """)
            }
        }

        //verify(service).save(device = device, value = value, timestamp = any())
        verify(service).save(eq(device), eq(value), any())

    }
}
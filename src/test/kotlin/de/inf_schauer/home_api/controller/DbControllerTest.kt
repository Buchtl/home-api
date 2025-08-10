package de.inf_schauer.home_api.controller

import de.inf_schauer.home_api.dto.TempDto
import de.inf_schauer.home_api.service.DbService
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest(DbController::class)
class DbControllerTest(@Autowired private val mockMvc: MockMvc) {
    @MockBean
    lateinit var service: DbService

    @Test
    fun `should call service to save`() {
        val device = "room_1"
        val value = 36.2f
        TempDto(device = device, value = value)
        val response = TempDto(device = device, value = value)

        whenever(service.save(device = any(), value = any())).thenReturn(response)

        mockMvc.post("/temp") {
            contentType = MediaType.APPLICATION_JSON
            content = """{"device":"sensor1","value":42.0}"""
        }.andExpect {
            status { isOk() }
        }

        verify(service).save(device = any(), value = any())
    }
}
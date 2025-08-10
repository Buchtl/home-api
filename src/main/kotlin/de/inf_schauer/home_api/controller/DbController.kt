package de.inf_schauer.home_api.controller

import TempEntity
import de.inf_schauer.home_api.dto.TempDto
import de.inf_schauer.home_api.service.DbService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/temp")
class DbController(private val service: DbService) {

    @PostMapping
    fun create(@RequestBody request: CreateExampleRequest): TempDto {
        val saved = service.save(request.device, request.value)
        return TempDto(device = saved.device, value = saved.value)
    }
}

data class CreateExampleRequest(
    val device: String, val value: Float
)

package de.inf_schauer.home_api.controller

import de.inf_schauer.home_api.service.DbService
import de.inf_schauer.home_api.temp.TempDtoCreate
import de.inf_schauer.home_api.temp.TempResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/temp")

class TempController(private val service: DbService) {
    @PostMapping
    fun create(@RequestBody tempDtoCreate: TempDtoCreate): TempResponse {
        return service.save(device = tempDtoCreate.device, value = tempDtoCreate.value)
    }
}
package de.inf_schauer.home_api.controller

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/health")
class HealthController {
    private val logger = LoggerFactory.getLogger(javaClass)

    @GetMapping
    fun health(): String {
        logger.info("healthy")
        return "healthy"
    }
}
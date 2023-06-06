package com.firewoody.base.api.controller

import com.firewoody.base.integrated.webservice.api.ApiRequestMapping
import org.apache.logging.log4j.LogManager
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class TestController(

) {
    companion object {
        private val log = LogManager.getLogger()
    }

    @ApiRequestMapping("/test", method = [RequestMethod.GET])
    fun getTest() {

    }
}
package com.firewoody.base.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication(scanBasePackages = ["com.firewoody.base"])
@ServletComponentScan(basePackages = ["com.firewoody.base"])
class ApiApplication {

}

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}
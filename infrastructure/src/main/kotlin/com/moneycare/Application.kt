package com.moneycare

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan(
    basePackages = ["com.moneycare"]
) open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

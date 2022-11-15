package com.moneycare

import com.moneycare.setting.app.MoneyCareConfigData
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan(
    basePackages = ["com.moneycare"]
) open class Application(
    private var moneyCareConfigData: MoneyCareConfigData
) : CommandLineRunner {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun run(vararg args: String?) {
        log.info("app starts...")
        log.info(moneyCareConfigData.keyWords.toString())
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}

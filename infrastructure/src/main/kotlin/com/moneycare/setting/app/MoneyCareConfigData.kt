package com.moneycare.setting.app

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "money-care")
open class MoneyCareConfigData {
    lateinit var keyWords: List<String>
}
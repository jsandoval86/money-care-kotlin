package com.moneycare.setting

import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Component

@Component
@EnableJpaRepositories(basePackages = ["com.moneycare"])
class JpaConfiguration
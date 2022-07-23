package io.mostafaeldahshan.simon_and_kucher.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.mostafaeldahshan.simon_and_kucher.model")
@EnableJpaRepositories("io.mostafaeldahshan.simon_and_kucher.repos")
@EnableTransactionManagement
public class ModelConfig {
}

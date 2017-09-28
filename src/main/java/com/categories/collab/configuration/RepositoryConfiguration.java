package com.categories.collab.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.categories.collab.domain"})
@EnableJpaRepositories(basePackages = {"com.categories.collab.repositories"})
public class RepositoryConfiguration {

}
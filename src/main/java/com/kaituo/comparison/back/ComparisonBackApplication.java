package com.kaituo.comparison.back;

import com.coxautodev.graphql.tools.SchemaParserDictionary;
import com.kaituo.comparison.back.core.dto.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableConfigurationProperties
@EnableTransactionManagement
@EnableCaching
public class ComparisonBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComparisonBackApplication.class, args);
    }

    @Bean
    SchemaParserDictionary schemaParserDictionary() {
        return new SchemaParserDictionary()
                .add(CreatedUser.class)
                .add(ErrorContainer.class)
                .add(LoginPayload.class)
                .add(Dog.class)
                .add(Fish.class);
    }

}

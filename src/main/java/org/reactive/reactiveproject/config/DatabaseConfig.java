package org.reactive.reactiveproject.config;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.Duration;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Bean
    public ConnectionPool connectionPool(ConnectionFactory connectionFactory) {
        ConnectionPoolConfiguration poolConfiguration = ConnectionPoolConfiguration.builder(connectionFactory)
                .initialSize(10)
                .maxSize(20)
                .maxIdleTime(Duration.ofSeconds(30))
                .maxAcquireTime(Duration.ofSeconds(30))
                .maxCreateConnectionTime(Duration.ofSeconds(30))
                .validationQuery("SELECT 1")
                .build();
        return new ConnectionPool(poolConfiguration);
    }

    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return new R2dbcTransactionManager(connectionFactory);
    }
}
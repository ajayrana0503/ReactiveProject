package org.reactive.reactiveproject.scheduler;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.PoolMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConnectionPoolScheduler {

    @Autowired
    private ConnectionPool connectionPool;

    @Scheduled(fixedRate = 1000)
    public void logConnectionPoolStatus() {
        PoolMetrics metrics = connectionPool.getMetrics().orElse(null);
        if (metrics != null) {
            System.out.printf("Connection Pool Status: Active Connections: %d, Max Connections: %d, Idle Connections: %d%n",
                    metrics.acquiredSize(), metrics.getMaxAllocatedSize(), metrics.idleSize());
        } else {
            System.out.println("Connection Pool Metrics are not available.");
        }
    }
}
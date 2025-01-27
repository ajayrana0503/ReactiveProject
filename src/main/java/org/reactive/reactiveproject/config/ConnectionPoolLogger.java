package org.reactive.reactiveproject.config;

import io.r2dbc.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConnectionPoolLogger {

    @Autowired
    private ConnectionPool connectionPool;

    @Scheduled(fixedRate = 100)
    public void logConnectionPoolStatus() {
        System.out.print("Active connections: " + connectionPool.getMetrics().get().acquiredSize() +" ");
        System.out.print("Idle connections: " + connectionPool.getMetrics().get().idleSize() + " ");
        System.out.print("Total connections: " + connectionPool.getMetrics().get().allocatedSize()  +" ");
        System.out.println("Threads awaiting connection: " + connectionPool.getMetrics().get().pendingAcquireSize());
    }
}
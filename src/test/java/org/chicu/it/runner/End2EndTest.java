package org.chicu.it.runner;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.ContainerState;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class End2EndTest {

    @Test
    @Disabled
    public void testDockerComposeHealthCheck() {
        // Path to the docker-compose.yml file
        File composeFile = new File("src/test/resources/docker-compose.yml");

        try (DockerComposeContainer<?> composeContainer = new DockerComposeContainer<>(composeFile)
                .withExposedService("sut4test", 8081, Wait.forHttp("/api/v1/employees")
                        .forStatusCode(200)
                        .withStartupTimeout(Duration.ofSeconds(30)))) {

            composeContainer.start();

            // Check if the service is up and responding
            boolean isHealthy = composeContainer.getContainerByServiceName("sut4test")
                    .map(ContainerState::isRunning)
                    .orElse(false);

            assertTrue(isHealthy, "The container health check failed.");
        }
    }


}

package org.chicu.service;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WireMockTest(httpPort = 8082)
class EmployeeMetadataGatewayServiceTest {

    private RestTemplate restTemplate;

    @Autowired
    private EmployeeMetadataGatewayService gatewayService;

    @BeforeEach
    public void setup() {
        restTemplate = new RestTemplate();
        // Reset WireMock before each test to avoid state issues
        WireMock.reset();
    }

    @Test
    public void testGetExternalData_withValidId_shouldReturnExpectedData() {
        String expectedEmployeeDetails = "Employee 1 details";
        stubFor(get(urlPathEqualTo("/another-service/api/v1/employees/1"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withStatus(200)
                        .withBody(expectedEmployeeDetails)));

        // Act
        String result = gatewayService.getEmployeeDetails(1L);

        // Assert
        assertEquals(expectedEmployeeDetails, result,
        "Employee details do not match");

        // Verify WireMock was called correctly
        verify(getRequestedFor(urlPathEqualTo("/another-service/api/v1/employees/1")));
    }
}
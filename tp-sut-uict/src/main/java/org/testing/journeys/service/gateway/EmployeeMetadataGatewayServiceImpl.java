package org.testing.journeys.service.gateway;

import org.testing.journeys.service.EmployeeMetadataGatewayService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeMetadataGatewayServiceImpl implements EmployeeMetadataGatewayService {

    private final RestTemplate restTemplate;

    public EmployeeMetadataGatewayServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public String getEmployeeDetails(Long employeeId){
        String url = "http://localhost:8082/another-service/api/v1/employees/{employeeId}";
        return restTemplate.getForObject(url, String.class, employeeId);
    }
}

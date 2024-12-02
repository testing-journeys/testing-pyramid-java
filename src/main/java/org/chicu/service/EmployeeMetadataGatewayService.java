package org.chicu.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeMetadataGatewayService {

    private final RestTemplate restTemplate;

    public EmployeeMetadataGatewayService() {
        this.restTemplate = new RestTemplate();
    }

    public String getEmployeeDetails(Long employeeId){
        String url = "http://localhost:8082/another-service/api/v1/employees/{employeeId}";
        return restTemplate.getForObject(url, String.class, employeeId);
    }
}

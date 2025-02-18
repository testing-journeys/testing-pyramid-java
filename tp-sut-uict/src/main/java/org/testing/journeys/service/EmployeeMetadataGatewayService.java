package org.testing.journeys.service;

import org.springframework.stereotype.Service;

/**
 * Assume this service interacts with another 3rd-party service to get employee details.
 */
@Service
public interface EmployeeMetadataGatewayService {

    String getEmployeeDetails(Long employeeId);

}

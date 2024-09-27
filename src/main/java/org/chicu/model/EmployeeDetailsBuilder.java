package org.chicu.model;

import lombok.experimental.UtilityClass;

@UtilityClass
class EmployeeDetailsBuilder {

    String buildUserDetails(String username) {
        if (username.isBlank()) {
            return "DEFAULT SYSTEM";
        } else {
            return String.format("Details: %s, %s", username, "magic processing");
        }
    }
}

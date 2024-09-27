package org.chicu.it.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.chicu.DemoApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberTestContextConfiguration {
}

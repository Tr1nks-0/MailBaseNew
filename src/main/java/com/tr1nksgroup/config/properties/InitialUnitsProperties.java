package com.tr1nksgroup.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:properties/initialUnits.properties")
public class InitialUnitsProperties {
    @Value("${test.case1}")
    private String testcase1;

    public String getTestcase1() {
        return testcase1;
    }

    public void setTestcase1(String testcase1) {
        this.testcase1 = testcase1;
    }
}

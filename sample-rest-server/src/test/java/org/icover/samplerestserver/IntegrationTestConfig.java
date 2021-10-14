package org.icover.samplerestserver;

import java.time.Clock;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class IntegrationTestConfig {

    private TestClock testClock = new TestClock();
    
    @Bean
    public TestClock systemUTCClock() {
        return testClock;
    }
    
    /*
    @Bean
    public Clock clock() {
        return testClock();
    }
    */

}

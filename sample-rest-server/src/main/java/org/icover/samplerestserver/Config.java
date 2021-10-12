package org.icover.samplerestserver;

import java.time.Clock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public Clock systemUTCClock() {
		return Clock.systemUTC();
	}
}

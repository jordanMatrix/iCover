package org.icover.samplerestserver;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.time.Clock;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingService {

	private final Clock clock;
	
	private final AtomicLong count = new AtomicLong();

	@Inject
	public PingService(final Clock clock) {
		this.clock = clock;
	}
	
	@RequestMapping(method= {GET, POST}, path="/ping")
	public Pong ping(@RequestParam final String greeting) {
		count.incrementAndGet();
		return new Pong(clock.millis(), greeting);
	}

	@GetMapping("/calls")
	public long calls( ) {
		return count.get();
	}
}

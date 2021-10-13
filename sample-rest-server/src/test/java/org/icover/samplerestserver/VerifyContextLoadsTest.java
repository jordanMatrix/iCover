package org.icover.samplerestserver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.time.Clock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(SilenceSpringInitLogging.class)
@SpringBootTest(properties = { "logging.level.root=WARN", "spring.main.banner-mode=log"  })
public class VerifyContextLoadsTest {
    @Autowired
    private Clock clock;

	@Test
	void verifyEmptyStats() {
	    assertThat(clock, is(not(nullValue())));
	}

}

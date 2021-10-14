package org.icover.samplerestserver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;

import org.hamcrest.text.MatchesPattern;
import org.icover.samplerestserver.TestClock.Mode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SilenceSpringInitLogging.class)
@WebMvcTest(controllers = PingService.class, properties = { "logging.level.root=WARN", "spring.main.banner-mode=log" })
@ContextConfiguration(classes = { IntegrationTestConfig.class })
public class PingServiceTest {
    
    final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestClock testClock;
    
    @Test
    public void verifyPing() throws Exception {
        final Instant now = Instant.now();
        testClock.mode = Mode.MANUAL;
        testClock.now = now;
        final String greeting = "foo%20bar";
        final MvcResult result = mockMvc.perform(get("/ping?greeting="+greeting))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        final String contentAsString = result.getResponse().getContentAsString();
        final Pong pong = objectMapper.readValue(contentAsString, Pong.class);

        assertThat(pong.echo, is(greeting));
        assertThat(pong.ts, is(now.toEpochMilli()));
    }
    
    @Test
    public void verifyCalls() throws Exception {
        final MvcResult result = mockMvc.perform(get("/calls"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        final String contentAsString = result.getResponse().getContentAsString();
        assertThat(contentAsString, MatchesPattern.matchesPattern("\\d+"));
    }
    
}

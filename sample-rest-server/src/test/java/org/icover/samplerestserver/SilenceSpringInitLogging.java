package org.icover.samplerestserver;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;

public class SilenceSpringInitLogging implements BeforeAllCallback {

    private static final Logger LOG = LoggerFactory.getLogger(PingServiceTest.class);
    static {
        // silence pre-spring init logging
        ((LoggerContext)LoggerFactory.getILoggerFactory()).getLogger("org.springframework").setLevel(Level.WARN);
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
    }

}

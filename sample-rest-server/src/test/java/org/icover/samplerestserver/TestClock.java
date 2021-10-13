package org.icover.samplerestserver;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class TestClock extends Clock {
    public enum Mode { CURRENT, MANUAL }

    public Mode mode = Mode.CURRENT;
    public Instant now = Instant.now();

    @Override
    public ZoneId getZone() {
        return null;
    }

    @Override
    public Clock withZone(ZoneId zone) {
        return null;
    }

    @Override
    public Instant instant() {
        switch (mode) {
        case CURRENT:
            return Instant.now();
        case MANUAL:
            return now;
        default:
            throw new IllegalStateException("Developer breakdown " + mode.getClass() + " not fully covered.");
        }
    }

}

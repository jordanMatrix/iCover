package org.icover.samplerestserver;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Pong {
	public final long ts;
	public final String echo;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Pong(@JsonProperty("ts") final long ts, @JsonProperty("echo") final String echo) {
		this.ts = ts;
		this.echo = echo;
	}
}

package org.icover.samplerestserver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class PingServerIntegrationTest {

    @Test
    public void launchAndExecuteRemotely() throws Exception {
        final File jarFile = new File("target/sample-rest-server-0.0.1-SNAPSHOT.jar");
        assertThat(jarFile.exists(), is(true));
        assertThat(jarFile.canRead(), is(true));
        
        final Runtime runtime = Runtime.getRuntime();
        final Process process = runtime.exec("java -jar "+jarFile);
        assertThat(process.isAlive(), is(true));
        
        final BufferedReader outReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        final BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        //System.err.println(errReader.readLine());
        assertThat(process.getErrorStream().available(), lessThan(1));
        
        final int timeoutSeconds = 5;
        final Instant timeout = Instant.now().plusSeconds(timeoutSeconds);
        boolean startedSuccessfully = false;
        while (process.isAlive() && Instant.now().isBefore(timeout)) {
            if (outReader.ready()) {
                final String line = outReader.readLine();
                System.out.println(line);
                if (line.contains("Started SampleRestServerApplication")) {
                    startedSuccessfully = true;
                };
            } else if (errReader.ready()) {
                while (errReader.ready()) {
                    System.err.println(errReader.readLine());
                }
                while (outReader.ready()) {
                    System.out.println(outReader.readLine());
                }
                break;
            }
            Thread.sleep(100);
        }
        assertThat(startedSuccessfully, is(true));
        
        startOutputDumperThread(process, outReader, errReader);
        
        
    }

    private void startOutputDumperThread(final Process process, final BufferedReader outReader, final BufferedReader errReader) {
        final Thread outDumper = new Thread(() -> {
            try {
                while (true) {
                    while (errReader.ready()) {
                        System.err.println(errReader.readLine());
                    }
                    while (outReader.ready()) {
                        System.out.println(outReader.readLine());
                    }
                    Thread.sleep(50);
                }
            } catch (Exception e) {
                System.out.println("Exception in out dumper: " + e);
            }
        });
        outDumper.setDaemon(true);
        outDumper.start();
    }
}

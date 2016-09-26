package io.thoeni;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws UnknownHostException {
        final Clock clock = new NanoClock();
        System.out.printf("Calling the hostname resolution method...%n");
        final Instant startTime = Instant.now(clock);
        String hostName = InetAddress.getLocalHost().getHostName();
        final Instant endTime = Instant.now(clock);
        System.out.printf("Method called, hostname %s, elapsed time: %d (ms)%n", hostName, TimeUnit.NANOSECONDS.toMillis(Duration.between(startTime, endTime).toNanos()));
    }
}

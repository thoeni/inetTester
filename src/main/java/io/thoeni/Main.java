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

        String domain = System.getProperty("domain");
        if (domain == null || domain.trim().length() == 0) {
            return;
        }
        System.out.printf("Calling the domain/hostname resolution method...%n");
        final Instant startTime2 = Instant.now(clock);
        InetAddress[] allByName = InetAddress.getAllByName(domain);
        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress);
        }
        final Instant endTime2 = Instant.now(clock);
        System.out.printf("Domain resolve called, domain %s, elapsed time: %d (ms)%n", domain, TimeUnit.NANOSECONDS.toMillis(Duration.between(startTime2, endTime2).toNanos()));
    }
}

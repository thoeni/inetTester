## InetAddress tester
Small class (and jar) to quickly check the elapsed time spent from the Java layer to access the localhost domain name.

I had few issues after upgrading from MacOS X El Capitan to MacOS Sierra and now the elapsed time passed from ~5ms-30ms to ~5000ms

###Usage:
`java -jar bin/inetTester.jar`

####Solution to the issue:
If the call is slow on your Mac (or other OS?) it could be solved by adding the hostname that the application will return on your hosts file, pointing to 127.0.0.1 like:

```
127.0.0.1   localhost mbpro.local
::1         localhost mbpro.local
```

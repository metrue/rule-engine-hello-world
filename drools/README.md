### Drools Hello World

```
$ mvn compile exec:java -Dexec.mainClass=demo.App -Dexec.cleanupDaemonThreads=false

time usage: 1743.0 ms
```

with Session Pool
```
$ mvn compile exec:java -Dexec.mainClass=demo.AppSessionPool -Dexec.cleanupDaemonThreads=false

time usage: 796.0 ms
```

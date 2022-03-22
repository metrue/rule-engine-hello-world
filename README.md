# aviator

```
$ cd aviator;
$ mvn compile exec:java -Dexec.mainClass=demo.Aviator -Dexec.cleanupDaemonThreads=false
time usage: 13418.0
=====================
result is: true
=====================
```

# groovy

```
$ cd aviator;
$ mvn compile exec:java -Dexec.mainClass=demo.Groovy -Dexec.cleanupDaemonThreads=false
groovy time usage: 36155.0
=====================
result is: true
=====================
```

# drools

```
$ cd drools;
$ mvn compile exec:java -Dexec.mainClass=demo.App -Dexec.cleanupDaemonThreads=false

time usage: 1743.0 ms
```

with Session Pool
```
$ cd drools;
$ mvn compile exec:java -Dexec.mainClass=demo.AppSessionPool -Dexec.cleanupDaemonThreads=false

time usage: 796.0 ms
```

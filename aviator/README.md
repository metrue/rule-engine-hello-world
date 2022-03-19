#
```
mvn compile exec:java -Dexec.mainClass=App
```

```
[WARNING] /Users/minhuang/Development/Bookings/rule-engine-hello-world/aviator/src/main/java/App.java: Recompile with -Xlint:deprecation for details.
[INFO]
[INFO] --- exec-maven-plugin:3.0.0:java (default-cli) @ EL-benchmark ---
aviator time usage: 3.0
=====================
result is: true
=====================
WARNING: An illegal reflective access operation has occurred
WARNING: Illegal reflective access by org.codehaus.groovy.reflection.CachedClass$3$1 (file:/Users/minhuang/.m2/repository/org/codehaus/groovy/groovy/1.8.0/groovy-1.8.0.jar) to method java.lang.Object.finalize()
WARNING: Please consider reporting this to the maintainers of org.codehaus.groovy.reflection.CachedClass$3$1
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
WARNING: All illegal access operations will be denied in a future release
groovy time usage: 54.0
=====================
result is: true
=====================
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.069 s
[INFO] Finished at: 2022-03-19T16:59:40+08:00
[INFO] ------------------------------------------------------------------------
```

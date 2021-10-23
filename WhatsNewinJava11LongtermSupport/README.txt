# Setting up project in IntelliJ
https://stackoverflow.com/questions/52340914/intellij-cant-find-java-net-http-when-compiling-with-java-11/52342080
https://mkyong.com/maven/maven-error-invalid-target-release-1-11/

# Java 11
What's new in Java 9
Java 9 Modularity: First Look
What's new in Java 10: Local-variable Type Inference
java generics
java lambda's

https://www.baeldung.com/java-single-file-source-code


Module system
Java Flight Recorder
Java Mission Control

Launching Single-file Source-code
Scripting (on Linux and Mac-OS not on Windows)
 
JEP 320 (Java Enhanced Proposal) - Describes the removal of enterprise API's

JavaFX is not bundled in the JDK anymore. But you can still add it as a Maven dependency


- Applets (removed)
- Java Web Start (removed)
- Nashorn (deprecated)



HttpClient API
- send
- sendAsync



$ jshell


String class
- repeat()
- isBlank()
- strip()
- lines()

Files class
- String readString(Path path)
- String readString(Path path, Charset cs)  overload
- Path writeString(Path path, CharSequence cs, OpenOption options)
- Path writeString(Path path, CharSequence cs, Charset cs, OpenOption options)  overload

Library upgrade
Optional::isEmpty
Predicate::not

Java 10: Local-variable Type Inference

var in lambdas

Nest-based Access-control

TLS1.3 (Transport Layer Security)


17 Java Enhancement Proposals:
openjdk.java.net/projects/jdk/11/
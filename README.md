![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/apache/maven.svg?label=License)
[![Maven Central](https://img.shields.io/maven-central/v/org.apache.maven/apache-maven.svg?label=Maven%20Central)](https://search.maven.org/artifact/org.apache.maven/apache-maven)

# safe-call
safe call method function，and don't worry about exception throwing errors

# What this is
This is a set of security wrapper classes. The error of the wrapped function will not affect the caller, and the underlying throwable can be consumed separately;
* 这是一套安全包装 Wrap 类，被 wrap 的函数报错不会影响到调用者，底层的 throwable 可以被单独消费

# Quick-start
Maven:

```xml
<dependency>
    <groupId>io.github.kubrickliu</groupId>
    <artifactId>safe-call</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Example Code :

### 1. SafeCall (include the return value)
#### 1.1. simple use :
```java
SafeCall.wrap(() -> {
    // do real method function
});
```

#### 1.2. use with default value :
```java
SafeCall.wrap(() -> {
    // do real method function
}, {default_value}); // The second value is the default value in case of exception
```

#### 1.3. use with default value and consumer throwable : 
```java
SafeCall.wrap(() -> {
    // do real method function
}, {default_value}, throwable -> {
    // consumer throwable
});
```

### 2. SafeExec (exclude the return value)

#### 2.1. simple use :
```java
SafeExec.wrap(() -> {
    // do real method function
});
```

### 2.2. use and consumer throwable
```java
SafeExec.wrap(() -> {
    // do real method function
}, throwable -> {
    // consumer throwable
});
```
## Simple Dependency Injection Framework in Java

Small example project, that provides a field based dependency injection framework inspired by Spring. It includes
Spring's ``@Bean`` and ``@Autowired`` annotation for creating bean definitions respectively injecting those definitions
into fields. 

#### Sample Usage

```java
ApplicationContext context = new ApplicationContext();

// scan classes for bean definitions
context.scanClasses(BeanDefinitions.class);

// print all registered beans
context.printDeclaredBeans();

// inject dependencies
context.inject();

// print all registered beans after dependency injection
context.printDeclaredBeans();

// get Vehicle Bean from application context
Vehicle vehicle = context.getBean(Vehicle.class);
System.out.println(vehicle);
```

See [Runner.java](https://github.com/dop89/di-example/blob/master/src/main/java/com/github/dop89/test/Runner.java).


#### Limitations
The framework supports only field based injection. Maybe someday I'll add constructor based injection, too. Furthermore, 
all beans are registered by its type in the Application Context, meaning that you can't have different beans for 
a single type. 

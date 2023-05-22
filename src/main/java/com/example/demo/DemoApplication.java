package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.WeaverMessages;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(DemoApplication.DemoApplicationRuntimeHints.class)
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Aspect
    @Configuration
    public static class LifeCycleMethodAspect {
        @Around("com.example.demo.DemoApplication.LifeCycleMethodJoinPointConfig.orchestratorLifeCycleAnnotation()")
        public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
            return joinPoint.proceed();
        }
    }

    public static class LifeCycleMethodJoinPointConfig {
        @Pointcut("@annotation(com.example.demo.OrchestrationAction)")
        public void orchestratorLifeCycleAnnotation() {}
    }

    public static class DemoApplicationRuntimeHints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.resources().registerPattern("org/aspectj/weaver/weaver-messages.properties");
        }

    }

}

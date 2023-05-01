package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Inherited
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Autowired
@Qualifier
public @interface GrpcSpringClient {

    /**
     * Name of the gRPC client and must match the value in gRPC client properties
     * @return gRPC client name
     */
    String value();

}

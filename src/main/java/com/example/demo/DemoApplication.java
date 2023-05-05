package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public static BeanDefinitionRegistryPostProcessor postProcessor() {
        // Our real implementation walks all registered beans and registers definitions on demand based use of this annotation
        return new BeanDefinitionRegistryPostProcessor() {
            @Override
            public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
                String beanName = "GrpcClient_myclient";
                // Conditional because this runs again and duplgicates the AOT registered bean
                if (!registry.containsBeanDefinition(beanName)) {
                    AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder
                            .genericBeanDefinition(StubFactoryBean.class)
                            .addConstructorArgValue(MyClientBlockingStub.class)
                            .addConstructorArgValue("myclient")
                            .getBeanDefinition();
                    beanDefinition.addQualifier(new AutowireCandidateQualifier(GrpcSpringClient.class, "myclient"));
                    registry.registerBeanDefinition("GrpcClient_myclient", beanDefinition);
                }
            }

            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            }
        };
    }

    @Component
    static class RequiresGrpcClient {
        RequiresGrpcClient(@GrpcSpringClient("myclient") MyClientBlockingStub client) {
        }
    }

}

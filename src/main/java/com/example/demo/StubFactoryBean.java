package com.example.demo;

import org.springframework.beans.factory.FactoryBean;

class StubFactoryBean<T extends AbstractStub<?>> implements FactoryBean<T> {

    StubFactoryBean(Class<T> clientClass, String clientName) {
        // Real logic has factories and all kinds of ceremony, we ignore that here
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() {
        return (T) new MyClientBlockingStub();
    }

    @Override
    public Class<?> getObjectType() {
        return MyClientBlockingStub.class;
    }
}

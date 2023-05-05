package com.example.demo;

import org.springframework.beans.factory.FactoryBean;

class StubFactoryBean implements FactoryBean<AbstractStub> {

    StubFactoryBean(Class<?> clientClass, String clientName) {
        // Real logic has factories and all kinds of ceremony, we ignore that here
    }

    @Override
    public AbstractStub getObject() {
        return new MyClientBlockingStub();
    }

    @Override
    public Class<?> getObjectType() {
        return MyClientBlockingStub.class;
    }
}

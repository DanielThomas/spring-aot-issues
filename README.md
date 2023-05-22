Run `./gradlew nativeCompile` and run `build/native/nativeCompile/demo`:

```
2023-05-22T16:04:15.588+10:00 ERROR 18442 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'demoApplication': error can't bind type name 'com.example.demo.DemoApplication.LifeCycleMethodJoinPointConfig'
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:605) ~[demo:6.0.7]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:520) ~[demo:6.0.7]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[demo:6.0.7]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[demo:6.0.7]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[demo:6.0.7]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[demo:6.0.7]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:973) ~[demo:6.0.7]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:917) ~[demo:6.0.7]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:584) ~[demo:6.0.7]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:732) ~[demo:3.0.5]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:434) ~[demo:3.0.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:310) ~[demo:3.0.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1304) ~[demo:3.0.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1293) ~[demo:3.0.5]
	at com.example.demo.DemoApplication.main(DemoApplication.java:20) ~[demo:na]
Caused by: java.lang.IllegalArgumentException: error can't bind type name 'com.example.demo.DemoApplication.LifeCycleMethodJoinPointConfig'
	at org.aspectj.weaver.tools.PointcutParser.parsePointcutExpression(PointcutParser.java:319) ~[demo:na]
	at org.springframework.aop.aspectj.AspectJExpressionPointcut.buildPointcutExpression(AspectJExpressionPointcut.java:222) ~[na:na]
	at org.springframework.aop.aspectj.AspectJExpressionPointcut.obtainPointcutExpression(AspectJExpressionPointcut.java:193) ~[na:na]
	at org.springframework.aop.aspectj.AspectJExpressionPointcut.getClassFilter(AspectJExpressionPointcut.java:172) ~[na:na]
	at org.springframework.aop.support.AopUtils.canApply(AopUtils.java:226) ~[na:na]
	at org.springframework.aop.support.AopUtils.canApply(AopUtils.java:288) ~[na:na]
	at org.springframework.aop.support.AopUtils.findAdvisorsThatCanApply(AopUtils.java:320) ~[na:na]
	at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.findAdvisorsThatCanApply(AbstractAdvisorAutoProxyCreator.java:128) ~[demo:6.0.7]
	at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.findEligibleAdvisors(AbstractAdvisorAutoProxyCreator.java:97) ~[demo:6.0.7]
	at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.getAdvicesAndAdvisorsForBean(AbstractAdvisorAutoProxyCreator.java:78) ~[demo:6.0.7]
	at org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.wrapIfNecessary(AbstractAutoProxyCreator.java:366) ~[demo:6.0.7]
	at org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.postProcessAfterInitialization(AbstractAutoProxyCreator.java:318) ~[demo:6.0.7]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization(AbstractAutowireCapableBeanFactory.java:434) ~[demo:6.0.7]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1773) ~[demo:6.0.7]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:598) ~[demo:6.0.7]
	... 14 common frames omitted
```

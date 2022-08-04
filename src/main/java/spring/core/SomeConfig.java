package spring.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring.core")
public class SomeConfig implements BeanPostProcessor {
    private static final Logger logger = LogManager.getLogger(SomeConfig.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Invoke 0 (BeanDefinition has already been created.)");
        logger.info("Invoke 1");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Invoke 3");
        Class<?> beanClass = bean.getClass();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanClass);
        enhancer.setInterfaces(beanClass.getInterfaces());
        MethodInterceptor interceptor = (object, method, args, methodProxy) -> methodProxy.invokeSuper(object, args);
        enhancer.setCallback(interceptor);
        return enhancer.create();
    }
}

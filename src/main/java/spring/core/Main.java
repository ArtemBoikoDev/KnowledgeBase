package spring.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean lifecycle.
 *
 * @author Artem Boiko
 */
public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SomeConfig.class);
        SomeBean someBean = context.getBean(SomeBean.class);
        someBean.someMethod();
        logger.info(someBean.getClass());
    }
}

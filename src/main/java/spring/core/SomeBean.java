package spring.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SomeBean {
    private static final Logger logger = LogManager.getLogger(SomeBean.class);

    @PostConstruct
    public void init() {
        logger.info("Invoke 2");
    }

    public void someMethod() {
        logger.info("Invoke 4");
    }
}

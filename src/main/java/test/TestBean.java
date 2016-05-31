package test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by dheeraj on 30/5/16.
 */
@Configuration
@Component
public class TestBean {

    public void test(){
        System.out.println("TestBean called");
    }
}

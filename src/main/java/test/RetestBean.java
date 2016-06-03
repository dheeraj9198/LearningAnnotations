package test;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by dheeraj on 3/6/16.
 */
@Component
public class RetestBean {

    private String message = "test";
    private String data = "data";

    public void call() {
        System.out.println(message + "*" + data);
    }

    @Bean
    public GetBean getBean() {
        return new GetBean();
    }
}

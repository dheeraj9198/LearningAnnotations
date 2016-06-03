package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by dheeraj on 30/5/16.
 */
@Component
public class TestBean {

    @Inject
    private RetestBean retestBean;

    @Inject
    private GetBean getBean;

    public void test(){
        retestBean.call();
        getBean.testGetBean();
    }

}

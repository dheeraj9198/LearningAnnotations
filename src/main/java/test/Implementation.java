package test;

/**
 * Created by dheeraj on 30/5/16.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Implementation {

    @Autowired
    private TestBean testBean;

    @TestAnotation(name = "dheeraj", value = "sachan")
    public void test(String s) {
        System.out.println(s);
        testBean.test();
    }
}

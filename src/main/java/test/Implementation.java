package test;

/**
 * Created by dheeraj on 30/5/16.
 */

import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class Implementation {

    @Inject
    private TestBean testBean;

    @TestAnotation(name = "dheeraj", value = "sachan")
    public void test(String s) {
        System.out.println(s);
        testBean.test();
    }
}

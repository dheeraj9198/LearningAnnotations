package test;

/**
 * Created by dheeraj on 30/5/16.
 */
public class Implementation {

    @TestAnotation(name = "dheeraj", value = "sachan")
    public void test(String s) {
            System.out.println(s);
    }
}

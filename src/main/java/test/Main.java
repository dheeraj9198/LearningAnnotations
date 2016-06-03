package test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by dheeraj on 30/5/16.
 */
@Configuration
@ComponentScan("test")
@EnableAutoConfiguration
@SpringBootApplication
@Component
public class Main {

    @Inject
    private TestBean testBean;

    public static void main(String[] args) throws Exception {
        /*AbstractApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Reflections reflections = new Reflections(
                new ConfigurationBuilder().setUrls(
                        ClasspathHelper.forPackage("")).setScanners(
                        new MethodAnnotationsScanner()));
        Set<Method> methods = reflections.getMethodsAnnotatedWith(TestAnotation.class);
        for (Method method : methods) {
            System.out.println(method.getName());
            Annotation[] annotation = method.getDeclaredAnnotations();
            for (Annotation annotation1 : annotation) {
                TestAnotation testAnotation = (TestAnotation) annotation1;
                System.out.println(testAnotation.name());
            }
            method.invoke(method.getDeclaringClass().newInstance(), "testinggggggggggg");
        }*/
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Main main = context.getBean(Main.class);
        main.testBean.test();
    }

}

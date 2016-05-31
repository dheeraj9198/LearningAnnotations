package test;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

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
        main.testBean().test();
    }

    @Bean
    public TestBean testBean() {
        return new TestBean();
    }

}

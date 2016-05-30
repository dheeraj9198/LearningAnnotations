package test;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by dheeraj on 30/5/16.
 */
@Configuration
@ComponentScan(basePackages = "test")
public class Main {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(Main.class);
        ctx.refresh();

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
        }
    }

    @Bean
    public TestBean testBean() {
        return new TestBean();
    }

}

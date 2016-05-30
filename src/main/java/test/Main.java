package test;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by dheeraj on 30/5/16.
 */
public class Main {

    public static void main(String[] args) throws Exception {
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
            method.invoke(method.getDeclaringClass().newInstance(), "dmkljcnsalkcjn");
        }
    }
}

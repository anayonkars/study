package code.demoutils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by anayonkar on 26/2/16.
 */
final class FinalClass {
    public Integer data;
    public void method() {

    }
}
public class FinalDemo {
    public static void main(String[] args) {
        FinalClass fc = new FinalClass();
        Class c = fc.getClass();

        /*for(Field f : c.getDeclaredFields()) {
            System.out.println(f);
        }*/
        System.out.println(c.getName());
        System.out.println(Modifier.isFinal(c.getModifiers()));
        for(Method m : c.getMethods()) {
            System.out.println(m);
            System.out.println(Modifier.isFinal(m.getModifiers()));
        }
        for(Field f : c.getDeclaredFields()) {
            System.out.println(f);
            System.out.println(Modifier.isFinal(f.getModifiers()));
        }
        fc.data = Integer.valueOf(1);
        fc.data = Integer.valueOf(2);
    }
}

package code.dp.singleton;

/**
 * Created by anayonkar on 5/6/16.
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton == null);
    }
}

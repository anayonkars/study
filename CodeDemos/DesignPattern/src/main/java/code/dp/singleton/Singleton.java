package code.dp.singleton;

/**
 * Created by anayonkar on 5/6/16.
 */
class Singleton {
    private Singleton() {

    }
    private static class SingletonHolder {
        private static Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

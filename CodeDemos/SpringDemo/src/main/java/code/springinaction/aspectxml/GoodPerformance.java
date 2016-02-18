package code.springinaction.aspectxml;

/**
 * Created by ANAYONKS on 18/02/2016.
 */
public class GoodPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("GoodPerformance");
    }
}

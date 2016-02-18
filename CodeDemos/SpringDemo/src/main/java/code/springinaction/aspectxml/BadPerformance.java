package code.springinaction.aspectxml;

/**
 * Created by ANAYONKS on 18/02/2016.
 */
public class BadPerformance implements Performance {
    @Override
    public void perform() throws AspectException {
        System.out.println("BadPerformance");
        throw new AspectException();
    }
}

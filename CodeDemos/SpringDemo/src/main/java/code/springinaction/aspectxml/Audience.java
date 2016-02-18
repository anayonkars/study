package code.springinaction.aspectxml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by ANAYONKS on 18/02/2016.
 */
public class Audience {
    public void performance(){}

    public void silentCellPhones() {
        System.out.println("SilentCellPhones");
    }

    public void takingSeats() {
        System.out.println("TakingSeats");
    }

    public void applause() {
        System.out.println("APPLAUSE");
    }

    public void boo() {
        System.out.println("BOO");
    }

        public void watch(ProceedingJoinPoint pjp) throws Throwable {
        try {
            System.out.println("Around SilentCellPhones");
            System.out.println("Around TakingSeats");
            pjp.proceed();
            System.out.println("Around APPLAUSE");
        } catch (Throwable e) {
            System.out.println("Around BOO");
            throw e;
        }
    }
}

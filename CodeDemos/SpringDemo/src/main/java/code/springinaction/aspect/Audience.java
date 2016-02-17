package code.springinaction.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by anayonkar on 17/2/16.
 */
@Aspect
@Component
public class Audience {
    @Pointcut("execution(** code.springinaction.aspect.Performance.perform())")
    public void performance(){}

    @Before("performance()")
    public void silentCellPhones() {
        System.out.println("SilentCellPhones");
    }

    @Before("performance()")
    public void takingSeats() {
        System.out.println("TakingSeats");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("APPLAUSE");
    }

    @AfterThrowing("performance()")
    public void boo() {
        System.out.println("BOO");
    }

    @Around("performance()")
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

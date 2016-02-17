package code.springinaction.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by anayonkar on 17/2/16.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class Config {
    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean(name = "good")
    public Performance good() {
        return new GoodPerformance();
    }

    @Bean(name = "bad")
    public Performance bad() {
        return new BadPerformance();
    }
}

package code.springinaction.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ANAYONKS on 16/02/2016.
 */
@Configuration
@ComponentScan
public class SampleConfig {
    @Bean
    public SampleBean sampleBean() {
        return new SampleBean(3, dependent());
    }

    @Bean(name = "namedBean")
    public SampleBean newSampleBean() {
        return new SampleBean(5, newDependent());
    }

    @Bean
    public Dependent dependent() {
        return new Dependent(3);
    }

    @Bean
    public Dependent newDependent() {
        return new Dependent(5);
    }
}

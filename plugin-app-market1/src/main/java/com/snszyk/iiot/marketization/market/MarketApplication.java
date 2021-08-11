package com.snszyk.iiot.marketization.market;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication(
        scanBasePackages = {"com.snszyk"} ,
        exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
                org.activiti.spring.boot.SecurityAutoConfiguration.class
        }
)
//@EnableLocalMessageSupport(servicePackages = "com.snszyk.iiot.marketization")
@EnableJpaRepositories(basePackages = {"com.snszyk.iiot.marketization"})
//@EnableApi(basePackages = {"com.snszyk.iiot.marketization"})
@EntityScan(basePackages = {
        "com.snszyk.iiot.marketization",
        "com.snszyk.iiot.marketization.market.domain.marketelement.entity",
        "com.snszyk.iiot.marketization.market.domain.marketelement"
})
public class MarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }

}

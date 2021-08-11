package org.jeecg;

import io.ttyys.micrc.api.EnableApi;
import io.ttyys.micrc.integration.local.springboot.EnableLocalMessageSupport;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.util.oConvertUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 单体启动类（采用此类启动为单体模式）
 */
@Slf4j
@SpringBootApplication(
        scanBasePackages = {"com.snszyk", "org.jeecg"} ,
        exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
                org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class,
                org.activiti.spring.boot.SecurityAutoConfiguration.class
        }
)
@EnableLocalMessageSupport(servicePackages = "com.snszyk.iiot.marketization")
@EnableJpaRepositories(basePackages = {"com.snszyk.iiot.marketization"})
@EnableApi(basePackages = {"com.snszyk.iiot.marketization"})
@EntityScan(basePackages = {
        "com.snszyk.iiot.marketization",
        "com.snszyk.iiot.marketization.market.domain.marketelement.entity",
        "com.snszyk.iiot.marketization.market.domain.marketelement"
})
public class JeecgSystemApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JeecgSystemApplication.class);
    }

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(JeecgSystemApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = oConvertUtils.getString(env.getProperty("server.servlet.context-path"));
        log.info("\n----------------------------------------------------------\n\t" +
                "Application Jeecg-Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }

}
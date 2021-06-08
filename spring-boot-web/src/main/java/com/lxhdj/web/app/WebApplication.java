package com.lxhdj.web.app;

import com.lxhdj.web.swagger.Swagger2Config;
import net.sf.cglib.core.DebuggingClassWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan({"com.lxhdj"})
@EnableConfigurationProperties({Swagger2Config.class})
@MapperScan("com.lxhdj.dao.mapper")
public class WebApplication {
    public static void main(String[] args) {
//        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/workspace/spring-boot/target/cglib/");
        SpringApplication.run(WebApplication.class, args);
    }
}

package cn.ucmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ServletComponentScan
@Component
@EnableAutoConfiguration
@PropertySource(value = "classpath:jdbc.properties")  // 加载自定义的数据库配置信息
public class ShopmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopmallApplication.class, args);
	}

}

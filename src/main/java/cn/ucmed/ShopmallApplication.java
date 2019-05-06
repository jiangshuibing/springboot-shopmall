package cn.ucmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

@SpringBootApplication
@ServletComponentScan
@Component
@EnableAutoConfiguration
@PropertySource(value = "classpath:jdbc.properties")  // 加载自定义的数据库配置信息
public class ShopmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopmallApplication.class, args);
	}

	private ApiInfo buildApiInfo(){
		return new ApiInfoBuilder().build();
	}

}

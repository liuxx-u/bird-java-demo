package com.bird.demo.service.zero;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bird.demo")
@MapperScan("com.bird.demo.**.mapper")
@DubboComponentScan(basePackages = "com.bird.demo")
public class Bootstrap {

	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);

		System.out.println("=================================");
		System.out.println("[ZERO服务]启动完成!!!");
		System.out.println("=================================");
	}
}

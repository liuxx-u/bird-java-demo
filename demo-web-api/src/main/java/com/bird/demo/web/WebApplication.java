package com.bird.demo.web;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bird.demo.web")
@DubboComponentScan("com.bird.demo.web")
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);

		System.out.println("=================================");
		System.out.println("[API站点]启动完成!!!");
		System.out.println("=================================");
	}
}

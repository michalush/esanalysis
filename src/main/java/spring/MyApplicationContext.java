package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {""})
public class MyApplicationContext {

	@Bean
	public MyApplication application() {
		return new MyApplication();
	}

}

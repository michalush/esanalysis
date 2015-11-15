package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = {""})
public class ApplicationContext {

	@Bean
	public MyApplication application() {
		return new MyApplication();
	}

}

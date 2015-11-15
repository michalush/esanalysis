package spring;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"service"})
public class MyApplicationContext {

	@Bean
	public MyApplication application() {
		return new MyApplication();
	}

	@Bean
	public JestClient jestClient() {
		JestClientFactory jestClientFactory = new JestClientFactory();
		final HttpClientConfig httpClientConfig = new HttpClientConfig
				.Builder("http://localhost:9200")
				.multiThreaded(true).build();
		jestClientFactory.setHttpClientConfig(httpClientConfig);
		return jestClientFactory.getObject();
	}
}

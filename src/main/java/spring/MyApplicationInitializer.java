package spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyApplicationInitializer implements WebApplicationInitializer {
	private static final Logger LOG = LoggerFactory.getLogger(MyApplicationInitializer.class);

	public void onStartup(final ServletContext sc) throws ServletException {
		LOG.debug("Application starting up...");

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(MyApplicationContext.class);
		sc.addListener(new ContextLoaderListener(ctx));

		sc.addFilter("springSecurityFilterChain",
		             DelegatingFilterProxy.class).addMappingForUrlPatterns(
				null, false, "/*");

//		FilterRegistration.Dynamic filterEncoding = sc.addFilter("Filter Encoding", FilterEncoding.class);
//		filterEncoding.addMappingForUrlPatterns(null, true, "/*");
//		filterEncoding.setInitParameter("requestEncoding", "UTF-8");

		LOG.debug("Application initialized...");
	}
}

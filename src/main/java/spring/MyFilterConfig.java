package spring;

import org.apache.wicket.protocol.http.WicketFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class MyFilterConfig implements FilterConfig {
	private final Map<String, String> initParams;
	private ServletContext sc;

	public MyFilterConfig(ServletContext context) {
		sc = context;
		initParams = new HashMap<String, String>();
		initParams.put(WicketFilter.APP_FACT_PARAM, "org.apache.wicket.spring.SpringWebApplicationFactory");
		initParams.put("filterMappingUrlPattern", "/*");
		initParams.put("wicket.configuration", "deployment");
//		initParams.put("ignorePaths", "/css,/js,/images,/icons");
	}

	void addInitParam(String name, String value) {
		initParams.put(name, value);
	}

	public String getFilterName() {
		return "WicketFilter";
	}

	public ServletContext getServletContext() {
		return sc;
	}

	public String getInitParameter(String name) {
		return initParams.get(name);
	}

	public Enumeration<String> getInitParameterNames() {
		return new Vector(initParams.keySet()).elements();
	}
}

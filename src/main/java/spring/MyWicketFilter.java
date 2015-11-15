package spring;

import org.apache.wicket.protocol.http.WicketFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

public class MyWicketFilter extends WicketFilter {

	private FilterConfig wicketFilterConfig;

	public MyWicketFilter(final MyFilterConfig myFilterConfig) {
		super();
		wicketFilterConfig = myFilterConfig;
	}

	@Override
	public void init(boolean isServlet, FilterConfig filterConfig) throws ServletException {
		super.init(isServlet, wicketFilterConfig);
	}
}

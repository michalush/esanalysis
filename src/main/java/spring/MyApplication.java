package spring;

import frontend.StatisticPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

public class MyApplication extends WebApplication {
	@Override
	public Class<StatisticPage> getHomePage() {
		return StatisticPage.class;
	}

	@Override
	protected void init() {
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
	}


}

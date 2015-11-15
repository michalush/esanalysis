package frontend;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ElasticQueryExecutor;

import java.io.IOException;

public class StatisticPage extends WebPage {
	private static Logger LOG = LoggerFactory.getLogger(StatisticPage.class);
	@SpringBean
	private ElasticQueryExecutor elasticQueryExecutor;

	public StatisticPage() {
		add(createCountLabel("count"));
	}

	private Label createCountLabel(String id) {
		final String indexName = "stack";
		try {
			final Double stack = elasticQueryExecutor.getIndexEntitiesCount(indexName);
			return new Label(id, stack.toString());
		} catch (IOException e) {
			LOG.error("Failed to get count for {} index", indexName, e);
			return new Label(id, "unknown");
		}
	}
}

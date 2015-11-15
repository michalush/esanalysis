package service;

import io.searchbox.client.JestClient;
import io.searchbox.core.Count;
import io.searchbox.core.CountResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class ElasticQueryExecutor {
	@Resource
	private JestClient client;

	public Double getIndexEntitiesCount(String indexName) throws IOException {
		final Count count = new Count.Builder().addIndex(indexName).build();
		final CountResult countResult = client.execute(count);
		return countResult.getCount();
	}
}

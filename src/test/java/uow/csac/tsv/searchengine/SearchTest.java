package uow.csac.tsv.searchengine;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import uow.csac.tsv.searchengine.model.Results;
import uow.csac.tsv.searchengine.search.Engine;
import uow.csac.tsv.searchengine.search.Index;

/**
 *
 * @author jiangxin
 *
 */
public class SearchTest {

	/**
	 *
	 */
	@Before
	public void setUp() {
	}

	/**
	 *
	 */
	@Test
	public final void testSearch() {
		Index index = new Index();
		index.loadIndex("data/index.idx");
		Engine engine = new Engine();
		engine.setEngine(index.getIndex());
		ArrayList<Results> testList = engine.getResultSet("participate");
		for (int i = 0; i < testList.size(); i++) {
			testList.get(i).printInfo();
			System.out.println(i);
		}
	}

}

package uow.csac.tsv.searchengine;

import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Before;
import org.junit.Test;


/**
 * test the main function of SearchEngine.
 *
 * @author jiangxin
 *
 */
public class CreateIndexTest {

	/**
	 *
	 */
	@Before
	public void setUp() {
	}

	/**
	 * @throws IOException IOException
	 *
	 */
	@Test
	public final void testSearchEngine() throws IOException {

		String[] deleteDirs = new String[] { "data/srcDoc/", "data/titleDoc/", "data/wordDoc/" };
		for (String dirName : deleteDirs) {
			try {
				FileUtils.deleteDirectory(new File(dirName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

//		long start, end;
//		start = System.currentTimeMillis();
//		ExecutorService executors = Executors.newFixedThreadPool(Config.DEFAULT_NUM_OF_THREAD);
//		for (int i = 0; i < Config.DEFAULT_NUM_OF_THREAD; i++) {
//			executors.execute(new Crawler(new String[] { "http://www.uwindsor.ca" }));
//		}
//		executors.shutdown();
//
//		while (!executors.isTerminated()) {
//			continue;
//		}
//
//		end = System.currentTimeMillis();
//		System.out.println("爬虫程序共花费时间：" + (end - start));
	}

}

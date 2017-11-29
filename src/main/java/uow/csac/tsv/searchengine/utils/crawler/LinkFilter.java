package uow.csac.tsv.searchengine.utils.crawler;

/**
 *
 * @Author Tab Tu
 * @Update Nov.28 2017
 */
public interface LinkFilter {
	/**
	 *
	 * @param url url
	 * @return boolean
	 */
	boolean accept(String url);
}

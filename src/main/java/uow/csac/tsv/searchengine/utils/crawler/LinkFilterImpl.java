package uow.csac.tsv.searchengine.utils.crawler;

/**
 *
 * @Author Tab Tu
 * @Update Nov.28 2017
 */
public class LinkFilterImpl implements LinkFilter {

	/**
	 *
	 */
	@Override
	public final boolean accept(final String url) {
		return url.startsWith("http://news.nju.edu.cn")
				&& (url.endsWith(".html") || (url.contains("show_article") && !url.contains("#")));
	}

}

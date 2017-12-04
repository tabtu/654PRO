package uow.csac.tsv.searchengine.config;

/**
 * Configuration
 *
 * @Author Tab Tu
 * @Update Nov.28 2017
 *
 */
public final class Config {

	/**
	 * avoid to be construct a object.
	 */
	private Config() {

	}

	/**
	 * the default number of thread.
	 */
	public static final int DEFAULT_NUM_OF_THREAD = 5;

	/**
	 * the default connect timeout.
	 */
	public static final int DEFAULT_CONNECT_TIMEOUT = 5000;

	/**
	 * the default connect request timeout.
	 */
	public static final int DEFAULT_CONNECTION_REQUEST_TIMEOUT = 5000;

	/**
	 * the max amount of the seeds.
	 */
	public static final int MAX_SEEDS_NUM = 10;

	/**
	 * the default page number need to crawler.
	 */
	public static final int DEFAULT_PAGE_NUM_NEED_TO_CRAWLER = 10;

	/**
	 * the default length before and after the key word.
	 */
	public static final int DEFAULT_LEN_BEFORE_AFTER_KEYWORD = 20;

	/**
	 * the maximum number that retry when download.
	 */
	public static final int MAX_RETRY_TIMES = 5;

}

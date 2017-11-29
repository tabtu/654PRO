package uow.csac.tsv.searchengine.model;

/**
 * 结果模型，用来存放单个的检索结果.
 * String tmp = str + " " + fileName +"#@#" + title + "#@#" + hashMap.get(str) + "#@#" + num + "#next#"
 *
 * @Author Tab Tu
 * @Update Nov.28 2017
 */
public class Results implements Comparable<Results> {

	/** 词. */
	private String word;

	/** 源页面url地址. */
	private String url;

	/** 在本文档内的词频. */
	private int wordV;

	/** 本文档的标题. */
	private String title;

	/** 包含词的部分文章内容. */
	private String partContent;

	/**
	 *
	 */
	public Results() {
	}

	/**
	 *
	 * @param word
	 *            word
	 * @param result
	 *            result
	 */
	public Results(final String word, final String result) {
		this.word = word;
		if (result.indexOf("#@#") > 0) {
			String[] array = result.split("#@#");
			this.url = "http://" + array[0].replaceFirst("_", "/").replaceAll(".txt", "");
			this.title = array[1];
			this.partContent = array[2];
			this.wordV = Integer.parseInt(array[3].trim());
		}
	}

	/**
	 *
	 * @return String
	 */
	public final String word() {
		return word;
	}

	/**
	 *
	 * @return String
	 */
	public final String getUrl() {
		return this.url;
	}

	/**
	 *
	 * @return String
	 */
	public final String getTitle() {
		return this.title;
	}

	/**
	 *
	 * @return int
	 */
	public final int getWordV() {
		return this.wordV;
	}

	/**
	 *
	 * @return String
	 */
	public final String getPartContent() {
		return this.partContent;
	}

	/**
	 *
	 * @param v
	 *            int
	 */
	public final void addWordV(final int v) {
		this.wordV += v;
	}

	/**
	 *
	 */
	public final void printInfo() {
		System.out.println(word);
		System.out.println(url);

	}

	/**
	 *
	 */
	@Override
	public final int compareTo(final Results o) {
		return this.getWordV() - o.getWordV();
	}
}

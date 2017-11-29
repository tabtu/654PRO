/*
 * 描述：将分好词的文档统计词频并且形成倒排索引文件，存入index.txt文档中
 * 作者：蒋鑫
 * */
package uow.csac.tsv.searchengine.search;

import java.io.*;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import uow.csac.tsv.searchengine.config.Config;
import uow.csac.tsv.searchengine.config.Path;
import uow.csac.tsv.searchengine.utils.io.In;
import uow.csac.tsv.searchengine.utils.io.Out;

/**
 *
 * @Author Tab Tu
 * @Update Nov.28 2017
 */
public class Index {

	private HashMap<String, String> index;

	public Index() {

	}

	public void setIndex(HashMap<String, String> myhs) {
		this.index = myhs;
	}

	public HashMap<String, String> getIndex() {
		return index;
	}

	/**
	 * create index with CONFIG.PATH
	 * Path.WORD, Path.
	 * @throws IOException IOException
	 */
	public void createIndex() throws IOException {
		index = new HashMap<>();
		File dirFile = new File(Path.WORD);
		File[] fileList = dirFile.listFiles();

		if (fileList != null) {
			System.out.println("Now is analyzing words text files, Please wait......");
			long start = System.currentTimeMillis();
			for (int i = 0; i < fileList.length; i++) {
				String fileName = fileList[i].getName();
				System.out.println("\tAnalyzing : " + fileName);
				HashMap<String, Integer> hashMap = new HashMap<>();
				String content = FileUtils.readFileToString(new File(Path.WORD + fileName), "UTF-8");
				String[] wordArray = content.split(" ");
				for (int j = 0; j < wordArray.length; j++) {
					if (hashMap.keySet().contains(wordArray[j])) {
						Integer integer = (Integer) hashMap.get(wordArray[j]);
						int value = integer.intValue() + 1;
						hashMap.put(wordArray[j], new Integer(value));
					} else {
						hashMap.put(wordArray[j], new Integer(1));
					}
				}
				// get the title
				String titleOrigin = FileUtils.readFileToString(new File(Path.TITLE + fileName), "UTF-8");
				// the the content
				String fullContentOrigin = FileUtils.readFileToString(new File(Path.CONTENT + fileName), "UTF-8");
				for (String str : hashMap.keySet()) {
					String partContent = "";
					int wordStart = fullContentOrigin.indexOf(str);  // location
					while (wordStart > 0) {
						String strTmp;
						int s = 0, e = fullContentOrigin.length();
						if (wordStart > Config.DEFAULT_LEN_BEFORE_AFTER_KEYWORD) {
							s = wordStart - Config.DEFAULT_LEN_BEFORE_AFTER_KEYWORD;
						}
						if (e > (wordStart + Config.DEFAULT_LEN_BEFORE_AFTER_KEYWORD)) {
							e = wordStart + Config.DEFAULT_LEN_BEFORE_AFTER_KEYWORD;
						}
						strTmp = fullContentOrigin.substring(s, e);
						partContent += (strTmp + "......");
						fullContentOrigin = fullContentOrigin.substring(e);
						wordStart = fullContentOrigin.indexOf(str);
					}
					// into des order
					String tmp = fileName + "#@#" + titleOrigin + "#@#" + partContent + "#@#" + hashMap.get(str);
					if (index.keySet().contains(str)) {
						// include this word
						String value = (String) index.get(str);
						value += ("#->#" + tmp);
						index.put(str, value);
					} else {
						index.put(str, tmp);
					}
				}

			}
			long end = System.currentTimeMillis();
			System.out.println("Complete analyzing. Use " + (end - start) + "ms");
		}
	}

	public void loadIndex(String filename) {
		index = new HashMap<>();
		try {
			In reader = new In(filename);
			String ss = reader.readAll();
			String[] tmp = ss.split("#/#");
			for (String s : tmp) {
				String[] b = s.split("#:#");
				index.put(b[0], b[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Save Index to File
	 *
	 * @param filename filename include path
	 */
	public void saveIndex(String filename) {
		if (index.size() > 0) {
			StringBuilder value = new StringBuilder("");
			System.out.println("Creating index Now, Please wait......");
			long start = System.currentTimeMillis();
			for (String str : index.keySet()) {
				StringBuilder tmp = new StringBuilder(str).append("#:#").append(index.get(str));
				value.append(tmp);
				value.append("#/#");
			}
			System.out.println("Complete building index. Use " + (System.currentTimeMillis() - start) + "ms");

			System.out.println("Writing index to disk Now, Please wait......");
			start = System.currentTimeMillis();
			Out out = new Out(filename);
			out.print(value.toString());
			System.out.println("Complete building index file, Use " + (System.currentTimeMillis() - start) + "ms");
		}
	}
}

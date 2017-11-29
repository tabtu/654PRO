package uow.csac.tsv.searchengine.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @Author Tab Tu
 * @Updated Nov.23 2017
 */
public class ConvertHTML {
    public static String convertHTMLfile2String_Parser(String htmlfilename) {
        try {
            FileReader in = new FileReader(htmlfilename);
            HTMLtoText parser = new HTMLtoText();
            parser.parse(in);
            in.close();
            return parser.getText();
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] converHtmlfile2String_Jsoup(String filename) {
        File input = new File(filename);
        String[] result = new String[2];
        Document doc = null;
        try {
            doc = Jsoup.parse(input, "UTF-8");
            result[0] = doc.title();
            result[1] = doc.text();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

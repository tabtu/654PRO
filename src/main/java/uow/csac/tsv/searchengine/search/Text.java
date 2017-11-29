package uow.csac.tsv.searchengine.search;

import uow.csac.tsv.searchengine.config.Path;
import uow.csac.tsv.searchengine.utils.ConvertHTML;
import uow.csac.tsv.searchengine.utils.Func;
import uow.csac.tsv.searchengine.utils.SpiltWORD;
import uow.csac.tsv.searchengine.utils.io.Out;

import java.io.IOException;

/**
 *
 * @Author Tab Tu
 * @Update Nov.28 2017
 */
public class Text {

    /**
     *
     * @throws IOException
     */
    public static void Html2Text() throws IOException {
        String[] list = Func.getFilesFromPath(Path.HTML);
        if (list.length > 0) {
            for (int i = 0; i < list.length; i++) {
                String result[] = ConvertHTML.converHtmlfile2String_Jsoup(Path.HTML + list[i]);
                Out content = new Out(Path.CONTENT + list[i] + ".txt");
                content.println(result[1]);
                Out title = new Out(Path.TITLE + list[i] + ".txt");
                title.println(result[0]);
                System.out.println("Successful Decode ---> " + list[i]);
            }
        }

    }

    /**
     *
     */
    public static void SeparateWord() {
        SpiltWORD spilt = new SpiltWORD(Path.CONTENT, Path.WORD);
        spilt.segment();
    }
}

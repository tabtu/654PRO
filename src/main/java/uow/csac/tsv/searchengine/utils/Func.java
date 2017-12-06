package uow.csac.tsv.searchengine.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Functions in 654 Project
 *
 * @Author Tab Tu
 * @Updated Nov.23 2017
 */
public class Func {
    public static String[] getWords(String allcontent) {
        String regEx="[^a-z0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(allcontent);
        String tmp =  m.replaceAll("\n").trim();
        StringTokenizer st = new StringTokenizer(tmp.toString(),",.! \n");
        List<String> stmp = new ArrayList<>();
        while (st.hasMoreTokens()) {
            stmp.add(st.nextToken());
        }
        String[] result = new String[stmp.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stmp.get(i);
        }
        return result;
    }

    public static String[] getFilesFromPath(String path) {
        File[] files = new File(path).listFiles();
        List<String> tmp = new ArrayList<>();
        for (File file : files) {
            if(!file.isDirectory()) {
                if(file.getName().compareTo(".DS_Store") != 0) {
                    tmp.add(file.getName());
                }
            }
        }
        String[] result = new String[tmp.size()];
        return tmp.toArray(result);
    }
}

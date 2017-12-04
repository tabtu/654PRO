package uow.csac.tsv.searchengine.search;

import uow.csac.tsv.searchengine.config.Path;
import uow.csac.tsv.searchengine.model.Results;

import java.util.ArrayList;

public class Init {

    public static void main(String[] args) {
        String[] deleteDirs = new String[] {Path.CONTENT, Path.WORD };
        try {
//            Text.Html2Text();
//            Text.SeparateWord();

            Index index = new Index();

            index.createIndex();
            index.saveIndex("data/index.idx");

//            index.loadIndex("data/index.idx");
//            Engine engine = new Engine();
//            engine.setEngine(index.getIndex());
//            ArrayList<Results> testList = engine.getResultSet("css");
//            for (int i = 0; i < testList.size(); i++) {
//                testList.get(i).printInfo();
//                System.out.println(i);
//                System.out.println(testList.get(i).getPartContent());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

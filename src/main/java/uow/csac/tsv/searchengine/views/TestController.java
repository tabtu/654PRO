package uow.csac.tsv.searchengine.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uow.csac.tsv.searchengine.model.Results;
import uow.csac.tsv.searchengine.search.Engine;
import uow.csac.tsv.searchengine.search.Index;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public List<Results> test(HttpServletRequest request) {
        String key = request.getParameter("key");
        key.replace(' ', '&');
        Index index = new Index();
        index.loadIndex("data/index.idx");
        Engine engine = new Engine();
        engine.setEngine(index.getIndex());
        ArrayList<Results> resultlist = engine.getResultSet(key);
        for (int i = 0; i < resultlist.size(); i++) {
            resultlist.get(i).printInfo();
            System.out.println(i);
        }
        return resultlist;
    }
}

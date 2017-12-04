package uow.csac.tsv.searchengine.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uow.csac.tsv.searchengine.model.Results;
import uow.csac.tsv.searchengine.search.Engine;
import uow.csac.tsv.searchengine.search.Index;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private Engine engine;

    @Autowired
    private Index index;

    @GetMapping("/")
    public String index0() {
        return "/index";
    }

    @GetMapping("/index")
    public String index() {
        return "/index";
    }
    
    @GetMapping("/search")
    public String gsearch() {
    	return "/search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView psearch(HttpServletRequest request) {
        String key = request.getParameter("key");
        index.loadIndex("data/index.idx");
        engine.setEngine(index.getIndex());
        ArrayList<Results> resultlist = engine.getResultSet(key);
        for (int i = 0; i < resultlist.size(); i++) {
            resultlist.get(i).printInfo();
            System.out.println(i);
        }
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("results", resultlist);
        return mav;
    }

}

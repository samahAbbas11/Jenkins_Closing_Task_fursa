package com.example.demo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import static com.example.demo.Parser.readRssFeed;

@org.springframework.stereotype.Controller
public class AppController {
    @GetMapping(value = "/")
    public String rssForm(Model model) throws Exception {
        String readFeed = readRssFeed("http://www.ynet.co.il/Integration/StoryRss2.xml");

        model.addAttribute("feedParsed",readFeed);

        return "index";
    }
}

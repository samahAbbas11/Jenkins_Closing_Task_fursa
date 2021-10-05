package com.example.demo;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.io.IOException;
import java.net.URL;
public class Parser {

    /**
     * this function reads the RSS Feed from the given URL ,
     * parse the content into html table (As string)
     * returns the html table as string by the variable parsedFeed
     * @param feedUrl
     * @return
     * @throws IOException
     * @throws FeedException
     */
    static String readRssFeed(String feedUrl) throws IOException, FeedException {
        URL feedSource = new URL(feedUrl);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));
        String parsedFeed = "<table>"+"<tr align=\"right\">"
                +"<th>כותרת</th>"
                + "<th>תיאור</th>"
                +"<th>תאריך</th>"
                +"<th>קישור</th>"
                +" </tr>";
        for(Object o: feed.getEntries()) { //iterate over the entries in the RSS feed file
            SyndEntry entry = (SyndEntry) o;
            parsedFeed +=
                    "<tr align=\"right\">"
                    + "<th>" + entry.getTitle() + "</th>"
                    + "<td>" + entry.getDescription().getValue() + "</td>"
                    +"<td>" + entry.getPublishedDate() + "</td>"
                    + "<td>" + "<a href=" + entry.getLink() + ">" + "לחץ לכתבה" + "</a>" + "</td>";

        }
        parsedFeed+= "</table>";
        return parsedFeed;
    }



}

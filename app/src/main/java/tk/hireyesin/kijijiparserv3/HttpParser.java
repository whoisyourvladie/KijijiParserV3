package tk.hireyesin.kijijiparserv3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class HttpParser {


    private Document doc;
    private ArrayList<Item> itemList;

    public HttpParser() {
        itemList=new ArrayList<>();
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    private void connectToUrl(String url){
        doc = null;
        try {
            // Parse the doc using an XML parser
            doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", "", Parser.xmlParser());

        } catch (IOException e) {
            //Если не получилось считать
            e.printStackTrace();
        }

    }

    public ArrayList<Item> makeItemList(String url){
        connectToUrl(url);
        Elements items=doc.getElementsByTag("item");
        for(Element e:items){
            Item it= new Item();
            it.setTitle(e.select("title").text());
            it.setLink(e.select("link").text());
            it.setDescription(e.select("description").text());
            it.setImgUrl(e.select("enclosure").attr("url"));
            it.setPubDate(e.select("pubDate").text());
            it.setGeoLat(parseDouble(e.select("geo|lat").text()));
            it.setGeoLong(parseDouble(e.select("geo|long").text()));
            it.setPrice(parseDouble(e.select("g-core|price").text()));
            itemList.add(it);
        }

        return itemList;

    }

    private double parseDouble(String str){
        if (str==""||str==null)
            return 0;
            else
                return Double.parseDouble(str);
    }

}

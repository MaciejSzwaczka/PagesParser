/**
 * Created by maciejszwaczka on 02.11.2017.
 */
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.*;

import org.apache.poi.hssf.*;
import sun.nio.cs.StandardCharsets;


public class Parser {
    public static int index;
    private Parser()
    {
        this.index=0;
    }
    public static List<Product> parse(String url)
    {
        List<Product> products=new ArrayList<Product>();
        Document doc=null;
        for(int pageIndex=1;5>pageIndex;pageIndex++) {
            try {
                doc = Jsoup.connect(url+pageIndex+"/").userAgent("Mozilla").timeout(10000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        /*product-box col-xs-12-6 col-xs-12 col-sm-4 col-md-3 col-lg-2*/
            Elements elems = doc.getElementsByClass("product-box");
            for (Element elem : elems) {
                System.out.println(index);
                String name = elem.getElementsByClass("name").text();
                String sizesStr = elem.getElementsByClass("sizes").text();
                String priceStr = elem.getElementsByClass("price").text();
                double price = Double.parseDouble(priceStr.split(" ")[0]);
                Set<String> sizes = new TreeSet<String>();

                Set<String> imgSrc = new TreeSet<String>();
                String partsSizes[] = sizesStr.split(": ");
                partsSizes = partsSizes[1].split(",");
                for (String part : partsSizes) {
                    sizes.add(part);
                }
                Elements imagesSources = elem.getElementsByClass("photo-box");
                String status = elem.getElementsByClass("badge").text();

                for (Element element : imagesSources) {
                    Elements srcs = element.getElementsByTag("img");
                    for (Element src : srcs) {
                        imgSrc.add(src.absUrl("src"));
                    }
                }
                Document detailInfo = null;
                try {
                    detailInfo = Jsoup.connect(elem.getElementsByTag("a").first().absUrl("href")).timeout(100000).userAgent("Mozilla").get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Elements elements = detailInfo.getElementsByClass("col-xs-12-6");
                int ind = 0;
                String season = null, product = null, colour = null;
                for (Element element : elements) {
                    if (ind < 2) {
                        Elements tagNames = element.getElementsByTag("h4");
                        Elements values = element.getElementsByTag("p");
                        int i = 0;
                        for (Element str : tagNames) {
                            if (str.text().equals("Sezon:")) {
                                season = values.get(i).text();
                            } else if (str.text().equals("Produkt:")) {
                                product = values.get(i).text();
                            } else if (str.text().equals("Kolor:")) {
                                colour = values.get(i).text();
                            }
                            i++;
                        }
                    }
                    ind++;
                }
                Product prod = new Product(index, name, price, imgSrc, product, sizes, season, colour);
                products.add(prod);
                index++;
            }
        }
        return products;
    }
    
}

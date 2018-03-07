import java.util.*;
/**
 * Created by maciejszwaczka on 02.11.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        System.setProperty("file.encoding","UTF-8");
        Parser parser=new Parser();
        List<Product> mensWear=parser.parse("https://www.citysport.com.pl/kategoria/odziez/bluzy-meskie/");
        mensWear.addAll(parser.parse("https://www.citysport.com.pl/kategoria/odziez/koszulki-meskie/"));
        mensWear.addAll(parser.parse("https://www.citysport.com.pl/kategoria/odziez/dresy-meskie/"));
        XLSWriter.writeToXLS(mensWear,"Odziez meska");


        List<Product> childsWear=parser.parse("https://www.citysport.com.pl/kategoria/odziez/bluzy-dzieciece/");
        childsWear.addAll(parser.parse("https://www.citysport.com.pl/kategoria/odziez/dresy-dzieciece/"));
        childsWear.addAll(parser.parse("https://www.citysport.com.pl/kategoria/odziez/koszulki-dzieciece/"));
        XLSWriter.writeToXLS(childsWear,"Odziez dziecieca");

        List<Product> mensBoots=parser.parse("https://www.citysport.com.pl/kategoria/buty/buty-meskie/");
        XLSWriter.writeToXLS(mensBoots,"Buty meskie");

        List<Product> womensBoots= parser.parse("https://www.citysport.com.pl/kategoria/buty/buty-damskie/");
        XLSWriter.writeToXLS(womensBoots, "Buty damskie");

        List<Product> childsBoots=parser.parse("https://www.citysport.com.pl/kategoria/buty/buty-dzieciece/");
        XLSWriter.writeToXLS(childsBoots,"Buty dzieciece");

        List<Product> womensWear=parser.parse("https://www.citysport.com.pl/kategoria/odziez/bluzy-damskie/");
        womensWear.addAll(parser.parse("https://www.citysport.com.pl/kategoria/odziez/koszulki-damskie/"));
        XLSWriter.writeToXLS(womensWear,"Odziez damska");
    }
}

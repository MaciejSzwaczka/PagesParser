import java.util.*;
/**
 * Created by maciejszwaczka on 02.11.2017.
 */
public class Main {
    public static void main(String[] args)
    {
        System.setProperty("file.encoding","UTF-8");
        List<Product> mensWear=Parser.parse("https://www.citysport.com.pl/kategoria/odziez/bluzy-meskie/");
        mensWear.addAll(Parser.parse("https://www.citysport.com.pl/kategoria/odziez/koszulki-meskie/"));
        mensWear.addAll(Parser.parse("https://www.citysport.com.pl/kategoria/odziez/dresy-meskie/"));
        XLSWriter.writeToXLS(mensWear,"Odziez meska");


        List<Product> childsWear=Parser.parse("https://www.citysport.com.pl/kategoria/odziez/bluzy-dzieciece/");
        childsWear.addAll(Parser.parse("https://www.citysport.com.pl/kategoria/odziez/dresy-dzieciece/"));
        childsWear.addAll(Parser.parse("https://www.citysport.com.pl/kategoria/odziez/koszulki-dzieciece/"));
        XLSWriter.writeToXLS(childsWear,"Odziez dziecieca");

        List<Product> mensBoots=Parser.parse("https://www.citysport.com.pl/kategoria/buty/buty-meskie/");
        XLSWriter.writeToXLS(mensBoots,"Buty meskie");

        List<Product> womensBoots= Parser.parse("https://www.citysport.com.pl/kategoria/buty/buty-damskie/");
        XLSWriter.writeToXLS(womensBoots, "Buty damskie");

        List<Product> childsBoots=Parser.parse("https://www.citysport.com.pl/kategoria/buty/buty-dzieciece/");
        XLSWriter.writeToXLS(childsBoots,"Buty dzieciece");

        List<Product> womensWear=Parser.parse("https://www.citysport.com.pl/kategoria/odziez/bluzy-damskie/");
        womensWear.addAll(Parser.parse("https://www.citysport.com.pl/kategoria/odziez/koszulki-damskie/"));
        XLSWriter.writeToXLS(womensWear,"Odziez damska");
    }
}

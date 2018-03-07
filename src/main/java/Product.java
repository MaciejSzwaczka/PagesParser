import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int ID;
    private String name;
    private double price;
    private Set<String> img;
    private String description;
    private Set<String> sizes;
    private String season;
    private String colour;
    private int active=1;
    private int amount=200;
    private int inSale=1;

   /* private String */

    public Product(int ID,String name,double price,Set<String> img,String description,
                   Set<String> sizes,String season,String colour){
        this.ID=ID;
        this.name=name;
        this.price=price;
        this.img=img;
        this.description=description;
        this.sizes=sizes;
        this.season=season;
        this.colour=colour;

    }
    
}

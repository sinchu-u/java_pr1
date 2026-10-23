import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private static List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public void searchByCategory(int category){
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getCategory().getId() == category) {
                System.out.println(products.get(i));
            }
        }
    }
}

import java.util.*;
public class ProductService
{
    static HashMap<Integer,Product> products=new HashMap<>();
    
    public static boolean addProduct(Product p)
    {
        if (products.containsKey(p.id))
        {
            return false;
        }
        products.put(p.id,p);
        return true;
    }

    public static Product getProduct(int id)
    {
        return products.get(id);
    }

    public static boolean updateProduct(int id,String name,double price,int quantity)
    {
        if (products.containsKey(id))
        {
            products.put(id,new Product(id,name,price,quantity));
            return true;
        }
        return false;
    }

    public static void deleteProduct(int id)
    {
        products.remove(id);
    }

    public static Collection<Product> getAllProducts()
    {
        return products.values();
    }
}
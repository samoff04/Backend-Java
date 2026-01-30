import java.io.*;
public class FileService
{
    static String filePath="products.txt";

    public static void save()
    {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(filePath)))
        {
            for (Product p:ProductService.getAllProducts())
            {
                bw.write(p.id+","+p.name+","+p.price+","+p.quantity);
                bw.newLine();
            }
        }
        catch(Exception e)
        {
            System.out.println("Save failed");
        }
    }

    public static void load()
    {
        try(BufferedReader br=new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while((line=br.readLine())!=null)
            {
                String[] p=line.split(",");
                ProductService.addProduct(
                    new Product(
                        Integer.parseInt(p[0]),
                        p[1],
                        Double.parseDouble(p[2]),
                        Integer.parseInt(p[3])
                    )
                );
            }
        }
        catch(Exception e)
        {
            System.out.println("No existing products");
        }
    }
}
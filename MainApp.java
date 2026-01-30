import java.util.*;

public class MainApp
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        FileService.load();

        while(true)
        {
            System.out.println("\n1 Add Product");
            System.out.println("2 View Product");
            System.out.println("3 Update Product");
            System.out.println("4 Delete Product");
            System.out.println("5 View All");
            System.out.println("6 Exit");

            int ch=sc.nextInt();

            if (ch==1)
            {
                System.out.print("ID: ");
                int id=sc.nextInt();
                sc.nextLine();

                System.out.print("Name: ");
                String name=sc.nextLine();

                System.out.print("Price: ");
                double price=sc.nextDouble();

                System.out.print("Quantity: ");
                int qty=sc.nextInt();

                if (price<=0 || qty<0)
                {
                    System.out.print("Invalid price or quantity");
                    continue;
                }

                boolean added=ProductService.addProduct(
                    new Product(id,name,price,qty)
                );

                if(added)
                {
                    FileService.save();
                    System.out.println("Product added");
                }
                else
                {
                    System.out.println("Product ID already exists");
                }
            }
            else if (ch==2)
            {
                System.out.print("Enter ID: ");
                int id=sc.nextInt();

                Product p=ProductService.getProduct(id);
                if (p!=null)
                {
                    System.out.println(p.name+" Rs."+p.price+" Qty:"+p.quantity);
                }
                else
                {
                    System.out.println("Product not found");
                }
            }
            else if (ch==3)
            {
                System.out.print("Enter ID: ");
                int id=sc.nextInt();
                sc.nextLine();

                System.out.print("New Name: ");
                String name=sc.nextLine();

                System.out.print("New Price: ");
                double price=sc.nextDouble();

                System.out.print("New Quantity: ");
                int qty=sc.nextInt();

                boolean updated=ProductService.updateProduct(id, name, price, qty);
                if (updated)
                {
                    FileService.save();
                    System.out.println("Product updated");
                }
                else
                {
                    System.out.println("Product not found");
                }
            }
            else if (ch==4)
            {
                System.out.print("Enter ID: ");
                int id=sc.nextInt();
                ProductService.deleteProduct(id);
                FileService.save();
                System.out.println("Deleted");
            }
            else if (ch==5)
            {
                for (Product p:ProductService.getAllProducts())
                {
                    System.out.println(p.id+" "+p.name+" Rs"+p.price);
                }
            }
            else
            {
                FileService.save();
                break;
            }
        }
    }
}
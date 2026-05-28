import java.util.Scanner;
import model.Product;
import service.ProductService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();

        while (true) {

            System.out.println("\n1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());

                    service.addProduct(new Product(id, name, price));
                    break;

                case 2:
                    service.viewProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int searchId = Integer.parseInt(sc.nextLine());

                    service.searchProduct(searchId);
                    break;

                case 4:
                    System.out.print("Old Product ID: ");
                    int oldId = Integer.parseInt(sc.nextLine());

                    System.out.print("New ID: ");
                    int newId = Integer.parseInt(sc.nextLine());

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("New Price: ");
                    double newPrice = Double.parseDouble(sc.nextLine());

                    service.updateProduct(
                        oldId,
                        new Product(newId, newName, newPrice)
                    );
                    break;

                case 5:
                    System.out.print("Product ID to delete: ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    service.deleteProduct(deleteId);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
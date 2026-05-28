package service;

import model.Product;
import java.io.*;

public class ProductService {

    private final String FILE_PATH = "../data/products.txt";

    public void addProduct(Product product) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            bw.write(product.toString());
            bw.newLine();

            System.out.println("Product added successfully");

        } catch (IOException e) {
            System.out.println("Error adding product");
        }
    }

    public void viewProducts() {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println(
                    "ID: " + data[0] +
                    " | Name: " + data[1] +
                    " | Price: " + data[2]
                );

                found = true;
            }

            if (!found) {
                System.out.println("No products found");
            }

        } catch (IOException e) {
            System.out.println("Error reading products");
        }
    }

    public void searchProduct(int id) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == id) {

                    System.out.println(
                        "Found -> ID: " + data[0] +
                        " | Name: " + data[1] +
                        " | Price: " + data[2]
                    );
                    return;
                }
            }

            System.out.println("Product not found");

        } catch (IOException e) {
            System.out.println("Error searching product");
        }
    }

    public void deleteProduct(int id) {

        File inputFile = new File(FILE_PATH);
        File tempFile = new File("../data/temp.txt");
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == id) {
                    found = true;
                    continue;
                }

                bw.write(line);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error deleting product");
            return;
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            System.out.println("Product deleted");
        } else {
            System.out.println("Product not found");
        }
    }

    public void updateProduct(int id, Product updatedProduct) {

        File inputFile = new File(FILE_PATH);
        File tempFile = new File("../data/temp.txt");
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == id) {
                    bw.write(updatedProduct.toString());
                    found = true;
                } else {
                    bw.write(line);
                }

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error updating product");
            return;
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        if (found) {
            System.out.println("Product updated");
        } else {
            System.out.println("Product not found");
        }
    }
}
package service;

import model.User;
import java.io.*;

public class UserService {

    private final String FILE_PATH = "../data/users.txt";

    public void addUser(User user) {

        if (!user.getEmail().contains("@")) {
            System.out.println("Invalid email");
            return;
        }

        if (user.getPassword().length() < 4) {
            System.out.println("Password too short");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {

            bw.write(user.toString());
            bw.newLine();

            System.out.println("User added successfully");

        } catch (IOException e) {
            System.out.println("Error adding user");
        }
    }

    public void viewUsers() {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println(
                    "Username: " + data[0] +
                    " | Email: " + data[1]
                );
            }

        } catch (IOException e) {
            System.out.println("Error reading users");
        }
    }

    public void searchUser(String username) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equalsIgnoreCase(username)) {

                    System.out.println(
                        "Found: " + data[0] +
                        " | " + data[1]
                    );
                    return;
                }
            }

            System.out.println("User not found");

        } catch (IOException e) {
            System.out.println("Error searching user");
        }
    }

    public void deleteUser(String username) {

        File inputFile = new File(FILE_PATH);
        File tempFile = new File("../data/temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (!data[0].equalsIgnoreCase(username)) {
                    bw.write(line);
                    bw.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error deleting user");
            return;
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        System.out.println("User deleted");
    }

    public void updateUser(String username, User updatedUser) {

        File inputFile = new File(FILE_PATH);
        File tempFile = new File("../data/temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equalsIgnoreCase(username)) {
                    bw.write(updatedUser.toString());
                } else {
                    bw.write(line);
                }

                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error updating user");
            return;
        }

        inputFile.delete();
        tempFile.renameTo(inputFile);

        System.out.println("User updated");
    }

    public void loginUser(String email, String password) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data[1].equals(email) && data[2].equals(password)) {
                    System.out.println("Login successful");
                    return;
                }
            }

            System.out.println("Invalid credentials");

        } catch (IOException e) {
            System.out.println("Login error");
        }
    }
}
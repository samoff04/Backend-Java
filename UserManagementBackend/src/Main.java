import java.util.Scanner;
import model.User;
import service.UserService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserService service = new UserService();

        while (true) {

            System.out.println("\n1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Search User");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Login");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Username: ");
                    String username = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    service.addUser(new User(username, email, password));
                    break;

                case 2:
                    service.viewUsers();
                    break;

                case 3:
                    System.out.print("Enter username: ");
                    String searchName = sc.nextLine();

                    service.searchUser(searchName);
                    break;

                case 4:
                    System.out.print("Old Username: ");
                    String oldUser = sc.nextLine();

                    System.out.print("New Username: ");
                    String newUser = sc.nextLine();

                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();

                    System.out.print("New Password: ");
                    String newPassword = sc.nextLine();

                    service.updateUser(
                        oldUser,
                        new User(newUser, newEmail, newPassword)
                    );
                    break;

                case 5:
                    System.out.print("Username to delete: ");
                    String deleteUser = sc.nextLine();

                    service.deleteUser(deleteUser);
                    break;

                case 6:
                    System.out.print("Email: ");
                    String loginEmail = sc.nextLine();

                    System.out.print("Password: ");
                    String loginPassword = sc.nextLine();

                    service.loginUser(loginEmail, loginPassword);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
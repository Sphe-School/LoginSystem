import java.util.Scanner;

public class MainT1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        LoginSystem loginSystem = new LoginSystem(firstName, lastName);

        System.out.print("Create username: ");
        String username = scanner.nextLine();

        System.out.print("Create password: ");
        String password = scanner.nextLine();

        System.out.print("Enter South African cell number (e.g. +27838968976): ");
        String cellPhone = scanner.nextLine();

        String registrationMessage = loginSystem.registerUser(username, password, cellPhone);
        System.out.println(registrationMessage);

        // Only continue to login if registration was successful
        if (registrationMessage.equals("User has been registered")) {

            System.out.println("\n--- Login ---");

            System.out.println("Enter username: ");
            String enteredUsername = scanner.nextLine();

            System.out.println("Enter password: ");
            String enteredPassword = scanner.nextLine();

            boolean loginSuccess = loginSystem.loginUser(enteredUsername, enteredPassword);

            System.out.println(loginSystem.returnLoginStaus(loginSuccess));
        }

        scanner.close();
    }
}
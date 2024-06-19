package pack1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String loop = "y";
        while (loop.equals("y")) {
            System.out.println("******************** Movie management system Demo Project by Ravi Shiral *******************");
            System.out.println("1. Registration");
            System.out.println("2. Login");
            System.out.println("Enter Your Choice: ");
            
            Store s1 = new Store(scanner);
            int a = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (a) {
                case 1: {
                    try {
                        s1.registerUser();
                        System.out.println("Registered Successfully");
                    } catch (Exception e) {
                        System.out.println("Registration failed: " + e.getMessage());
                    }
                    break;
                }
                case 2: {
                    try {
                        s1.login();
                        System.out.println("Logged in Successfully");
                    } catch (Exception e) {
                        System.out.println("Login failed: " + e.getMessage());
                    }
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unexpected value: " + a);
            }
            System.out.println("Do you want to continue? (y/n)");
            loop = scanner.nextLine();
        }
        scanner.close();
    }
}

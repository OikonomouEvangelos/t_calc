package org.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Team Calculator started!");

        Scanner scanner = new Scanner(System.in);

        while (true) { // Επανάληψη μέχρι να επιλέξει ο χρήστης να σταματήσει
            double num1;
            double num2;
            char operator;
            double result = 0;

            System.out.print("Enter the first number: ");
            num1 = scanner.nextDouble();

            System.out.print("Enter an operator (+, -, *, /, ^, l for log): ");
            operator = scanner.next().charAt(0);

            // Έλεγχος έγκυρου τελεστή
            while (operator != '+' && operator != '-' && operator != '*' &&
                    operator != '/' && operator != '^' && operator != 'l') {
                System.out.print("Invalid operator! Please enter one of (+, -, *, /, ^, l): ");
                operator = scanner.next().charAt(0);
            }

            // Ζητάμε δεύτερο αριθμό ΜΟΝΟ αν δεν είναι τετράγωνο ή λογάριθμος
            if (operator != '^' && operator != 'l') {
                System.out.print("Enter the second number: ");
                num2 = scanner.nextDouble();
            } else {
                num2 = 0; // placeholder, δεν χρειάζεται
            }
            switch (operator) {
                case '/' -> {
                    while (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed!");
                        System.out.print("Please enter a non-zero number: ");
                        num2 = scanner.nextDouble();
                    }
                    result = num1 / num2;
                }
                case '^' -> result = Math.pow(num1, 2);



            }

            System.out.println("Result: " + result);

            System.out.print("Do you want to perform another calculation? (y/n): ");
            char choice = scanner.next().charAt(0);
            if (choice == 'n' || choice == 'N') {
                System.out.println("Exiting calculator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}

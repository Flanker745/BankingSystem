import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {

    public static void addAccount(
            ArrayList<Account> accounts,
            Scanner sc) {

        System.out.println("\n===== ADD ACCOUNT =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        System.out.print("Confirm PIN: ");
        String confirmPin = sc.nextLine();

        if (!pin.equals(confirmPin)) {

            System.out.println("PIN does not match.");
            return;
        }

        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        if (balance < 1000) {

            System.out.println("Minimum deposit is ₹1000.");
            return;
        }

        if (balance > 100000) {

            System.out.println("Maximum deposit is ₹100000.");
            return;
        }

        int newAccountNumber = 1001;

        for (Account account : accounts) {

            if (account.accountNumber >= newAccountNumber) {

                newAccountNumber = account.accountNumber + 1;
            }
        }

        Account account = new Account(
                newAccountNumber,
                name,
                pin,
                balance
        );

        accounts.add(account);

        FileManager.saveAccounts(accounts);

        System.out.println("Account created successfully.");
        System.out.println("Your Account Number is: " + newAccountNumber);
    }


    public static void removeAccount(
            ArrayList<Account> accounts,
            Scanner sc) {

        System.out.println("\n===== REMOVE ACCOUNT =====");

        System.out.print("Enter Account Number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        Account foundAccount = null;

        for (Account account : accounts) {

            if (account.accountNumber == accountNumber &&
                    account.pin.equals(pin)) {

                foundAccount = account;
                break;
            }
        }

        if (foundAccount == null) {

            System.out.println("Invalid Account Number or PIN.");
            return;
        }

        System.out.print("Are you sure? (yes/no): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {

            accounts.remove(foundAccount);

            FileManager.saveAccounts(accounts);

            System.out.println("Account removed successfully.");
        }
        else {

            System.out.println("Account removal cancelled.");
        }
    }
}
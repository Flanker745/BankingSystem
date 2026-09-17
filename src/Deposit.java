import java.util.ArrayList;
import java.util.Scanner;

public class Deposit {

    public static void depositMoney(
            Account account,
            ArrayList<Account> accounts,
            Scanner sc) {

        System.out.println("\n===== DEPOSIT MONEY =====");

        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0) {

            System.out.println("Invalid amount.");
            return;
        }

        if (account.balance + amount > 100000) {

            System.out.println("Maximum account balance is ₹100000.");
            return;
        }

        account.balance = account.balance + amount;

        FileManager.saveAccounts(accounts);

        TransactionHistory.addTransaction(
                account.accountNumber,
                "Deposit",
                amount
        );

        System.out.println("Money deposited successfully.");
        System.out.println("Current Balance: ₹" + account.balance);
    }
}
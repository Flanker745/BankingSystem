import java.util.ArrayList;
import java.util.Scanner;

public class Withdraw {

    public static void withdrawMoney(
            Account account,
            ArrayList<Account> accounts,
            Scanner sc) {

        System.out.println("\n===== WITHDRAW MONEY =====");

        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0) {

            System.out.println("Invalid amount.");
            return;
        }

        if (amount > account.balance) {

            System.out.println("Insufficient balance.");
            return;
        }

        account.balance = account.balance - amount;

        FileManager.saveAccounts(accounts);

        TransactionHistory.addTransaction(
                account.accountNumber,
                "Withdraw",
                amount
        );

        System.out.println("Please collect your cash.");
        System.out.println("Current Balance: ₹" + account.balance);
    }
}
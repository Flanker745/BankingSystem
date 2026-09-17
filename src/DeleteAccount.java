import java.util.ArrayList;
import java.util.Scanner;

public class DeleteAccount {

    public static boolean deleteAccount(
            Account account,
            ArrayList<Account> accounts,
            Scanner sc) {

        System.out.println("\n===== DELETE ACCOUNT =====");

        System.out.print(
                "Are you sure you want to delete your account? (yes/no): "
        );

        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("yes")) {

            accounts.remove(account);

            FileManager.saveAccounts(accounts);

            System.out.println("Account deleted successfully.");

            return true;
        }

        System.out.println("Account deletion cancelled.");

        return false;
    }
}
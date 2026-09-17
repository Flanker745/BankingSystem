import java.util.ArrayList;
import java.util.Scanner;

public class ChangePin {

    public static void changePin(
            Account account,
            ArrayList<Account> accounts,
            Scanner sc) {

        System.out.println("\n===== CHANGE PIN =====");

        System.out.print("Enter Current PIN: ");
        String oldPin = sc.nextLine();

        if (!account.pin.equals(oldPin)) {

            System.out.println("Wrong PIN.");
            return;
        }

        System.out.print("Enter New PIN: ");
        String newPin = sc.nextLine();

        System.out.print("Confirm New PIN: ");
        String confirmPin = sc.nextLine();

        if (!newPin.equals(confirmPin)) {

            System.out.println("PIN does not match.");
            return;
        }

        account.pin = newPin;

        FileManager.saveAccounts(accounts);

        System.out.println("PIN changed successfully.");
    }
}
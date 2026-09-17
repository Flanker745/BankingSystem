import java.util.ArrayList;

public class Authentication {

    public static Account login(
            ArrayList<Account> accounts,
            int accountNumber,
            String pin) {

        for (Account account : accounts) {

            if (account.accountNumber == accountNumber) {

                if (account.pin.equals(pin)) {

                    return account;
                }
                else {

                    System.out.println("Wrong PIN.");
                    return null;
                }
            }
        }

        System.out.println("Account not found.");

        return null;
    }
}
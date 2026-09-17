import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Account> accounts =
                FileManager.readAccounts();

        boolean running = true;

        System.out.println("================================");
        System.out.println("        ATM SIMULATION");
        System.out.println("================================");

        while (running) {

            System.out.println("\n--------- MAIN MENU ---------");
            System.out.println("1. Login");
            System.out.println("2. Add Account");
            System.out.println("3. Remove Account");
            System.out.println("4. Exit");
            System.out.println("-----------------------------");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("\nEnter Account Number: ");
                    int accountNumber = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter PIN: ");
                    String pin = sc.nextLine();

                    Account account =
                            Authentication.login(
                                    accounts,
                                    accountNumber,
                                    pin
                            );

                    if (account != null) {

                        System.out.println("\nLogin Successful!");
                        System.out.println("Welcome " + account.name);

                        boolean loggedIn = true;

                        while (loggedIn) {

                            System.out.println("\n--------- ATM MENU ---------");
                            System.out.println("1. Check Balance");
                            System.out.println("2. Deposit Money");
                            System.out.println("3. Withdraw Money");
                            System.out.println("4. Transaction History");
                            System.out.println("5. Change PIN");
                            System.out.println("6. Delete Account");
                            System.out.println("7. Logout");
                            System.out.println("----------------------------");

                            System.out.print("Enter your choice: ");
                            int atmChoice = sc.nextInt();
                            sc.nextLine();

                            switch (atmChoice) {

                                case 1:

                                    Balance.checkBalance(account);

                                    break;


                                case 2:

                                    Deposit.depositMoney(
                                            account,
                                            accounts,
                                            sc
                                    );

                                    break;


                                case 3:

                                    Withdraw.withdrawMoney(
                                            account,
                                            accounts,
                                            sc
                                    );

                                    break;


                                case 4:

                                    TransactionHistory.showHistory(
                                            account.accountNumber
                                    );

                                    break;


                                case 5:

                                    ChangePin.changePin(
                                            account,
                                            accounts,
                                            sc
                                    );

                                    break;


                                case 6:

                                    boolean deleted =
                                            DeleteAccount.deleteAccount(
                                                    account,
                                                    accounts,
                                                    sc
                                            );

                                    if (deleted) {

                                        loggedIn = false;
                                    }

                                    break;


                                case 7:

                                    System.out.println(
                                            "Logged out successfully."
                                    );

                                    loggedIn = false;

                                    break;


                                default:

                                    System.out.println(
                                            "Invalid choice."
                                    );
                            }
                        }
                    }

                    break;


                case 2:

                    AccountManager.addAccount(
                            accounts,
                            sc
                    );

                    break;


                case 3:

                    AccountManager.removeAccount(
                            accounts,
                            sc
                    );

                    break;


                case 4:

                    System.out.println(
                            "\nThank you for using the ATM."
                    );

                    running = false;

                    break;


                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }

        sc.close();
    }
}
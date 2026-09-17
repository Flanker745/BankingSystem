public class Balance {

    public static void checkBalance(Account account) {

        System.out.println("\n===== BALANCE =====");

        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("Name: " + account.name);
        System.out.println("Balance: ₹" + account.balance);
    }
}
import java.io.*;
import java.util.ArrayList;

public class FileManager {

    static String fileName = "data/accounts.txt";

    public static ArrayList<Account> readAccounts() {

        ArrayList<Account> accounts = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\|");

                int accountNumber = Integer.parseInt(data[0]);
                String name = data[1];
                String pin = data[2];
                double balance = Double.parseDouble(data[3]);

                Account account = new Account(
                        accountNumber,
                        name,
                        pin,
                        balance
                );

                accounts.add(account);
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Error reading account data.");
        }

        return accounts;
    }


    public static void saveAccounts(ArrayList<Account> accounts) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            for (Account account : accounts) {

                bw.write(
                        account.accountNumber + "|" +
                                account.name + "|" +
                                account.pin + "|" +
                                account.balance
                );

                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {

            System.out.println("Error saving account data.");
        }
    }
}
import java.io.*;
import java.util.Scanner;

public class TransactionHistory {

    static String fileName = "data/transactions.txt";


    public static void addTransaction(
            int accountNumber,
            String type,
            double amount) {

        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(fileName, true)
            );

            bw.write(
                    accountNumber + "|" +
                            type + "|" +
                            amount
            );

            bw.newLine();

            bw.close();

        } catch (Exception e) {

            System.out.println("Error saving transaction.");
        }
    }


    public static void showHistory(
            int accountNumber) {

        System.out.println("\n===== TRANSACTION HISTORY =====");

        boolean found = false;

        try {

            BufferedReader br =
                    new BufferedReader(
                            new FileReader(fileName)
                    );

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split("\\|");

                int accNo = Integer.parseInt(data[0]);

                if (accNo == accountNumber) {

                    System.out.println(
                            data[1] + " : ₹" + data[2]
                    );

                    found = true;
                }
            }

            br.close();

        } catch (Exception e) {

            System.out.println("No transaction history found.");
        }

        if (!found) {

            System.out.println("No transactions found.");
        }
    }
}
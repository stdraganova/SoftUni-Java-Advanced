package JavaAdvanced.DefiningClasses.BankAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        BankAccount bankAccount;
        //мап с ИД на акаунта за ключ и обекта на акаунта
        Map<Integer, BankAccount> accounts = new HashMap<>();

        while (!tokens[0].equals("End")){
            String command = tokens[0];

            switch (command){
                case "Create" -> {
                    bankAccount = new BankAccount();
                    int id = bankAccount.getId();
                    accounts.putIfAbsent(id, bankAccount);

                    System.out.printf("Account ID%d created%n", id);
                }
                case "Deposit" -> {
                    int id = Integer.parseInt(tokens[1]);
                    double amount = Double.parseDouble(tokens[2]);

                    if (!isValidId(id,accounts)){
                        System.out.println("Account does not exist");
                    }else {
                        accounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    }
                }
                case "SetInterest" -> {
                    double interest = Double.parseDouble(tokens[1]);
                    accounts.forEach((account, value) -> value.setInterestRate(interest));
                }
                case "GetInterest" -> {
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);

                    if (!isValidId(id,accounts)){
                        System.out.println("Account does not exist");
                    }else {
                        System.out.printf("%.2f%n",accounts.get(id).getInterestRate(years));
                    }
                }
            }
            tokens = scanner.nextLine().split("\\s+");
        }

    }

    private static boolean isValidId(int id, Map<Integer, BankAccount> accounts) {
        if (accounts.containsKey(id)){
            return true;
        }else {
            return false;
        }
    }
}


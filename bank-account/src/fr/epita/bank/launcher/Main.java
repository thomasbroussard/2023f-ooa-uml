package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Account;
import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.InvestmentAccount;
import fr.epita.bank.datamodel.SavingsAccount;
import fr.epita.bank.services.AccountService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AccountService accountService = new AccountService();
        System.out.println("Hello and welcome!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("type a customer name");
        String customerName = scanner.nextLine();
        System.out.println("type a customer address");
        String customerAddress = scanner.nextLine();
        System.out.println("type an initial balance");
        String initialBalance = scanner.nextLine();
        double initialBalanceAsDouble = Double.parseDouble(initialBalance);

        Customer customer = new Customer(customerName, customerAddress);

        SavingsAccount savingsAccount = new SavingsAccount(initialBalanceAsDouble, customer);
        InvestmentAccount investmentAccount = new InvestmentAccount(initialBalanceAsDouble, customer);

        savingsAccount.setInterestRate(-0.3);

        System.out.println(investmentAccount);
        System.out.println(savingsAccount);

        System.out.println("what amount would you like to withdraw from this account?");
        String rawAmount = scanner.nextLine();
        double amount = Double.parseDouble(rawAmount);

        accountService.withDraw(savingsAccount, amount);
        double currentPeriodInterests = accountService.calculateInstantInterests(savingsAccount);


        // To test if an account is of a specific type
        // List<Account> accounts;
        // boolean isSavingAccount = accounts.get(0) instanceof SavingsAccount;



    }
}

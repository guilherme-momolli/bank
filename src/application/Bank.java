package application;

import BankDates.AcountUser.BankData;

import java.util.Locale;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The User name: ");
        String userName = sc.nextLine();

        System.out.println("Enter The Acount Number: ");
        int accountNumber = sc.nextInt();


        BankData bd = new BankData(accountNumber, userName);
        initialDeposit(sc, bd);
        executOperations(sc, bd);
        sc.close();
    }

    private static void executOperations(Scanner sc, BankData bd) {
        boolean newOperation = true;
        while (newOperation) {
            System.out.println("Do you want do new operation? ");
            newOperation = sc.nextInt() == 1;
            if (!newOperation){
                break;
            }

            executOperation(sc, bd);
        }


    }

    private static void executOperation(Scanner sc, BankData bd) {
        System.out.println("Choose you operation (1)Deposit (2)Wihtdraw ");
        int operation = sc.nextInt();

        if(operation == 1) {
            opDeposit(sc, bd);
        }
        else if(operation == 2) {
            opWithdraw(sc, bd);
        }
        else{
            System.out.println("Invalid operation.");
        }
    }

    private static void opWithdraw(Scanner sc, BankData bd) {
        System.out.println("Enter a withdraw value: ");
        bd.withDraw(sc.nextDouble());

        System.out.println(bd.dataUpdateStr());
    }

    private static void opDeposit(Scanner sc, BankData bd) {
        System.out.println("Enter a deposit value: ");
        bd.addDeposit(sc.nextDouble());

        System.out.println(bd.dataUpdateStr());
    }

    private static void initialDeposit(Scanner sc, BankData bd) {
        System.out.println("Is there an initial deposit:  ");

        System.out.println("Y(1)/N(0)");
        int executInitialDeposit = sc.nextInt();

        //diferente !=
        if (executInitialDeposit != 1) {
            return;
        }

        opDeposit(sc, bd);
    }
}

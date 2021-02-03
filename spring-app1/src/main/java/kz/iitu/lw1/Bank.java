package kz.iitu.lw1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    private List<Account> accountList = new ArrayList<>();
    private ATM atm;

    Scanner in = new Scanner(System.in);

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public void listAccounts() {
        for (Account accountt: accountList) {
            System.out.println(accountt.getOwnerFullName() + " " + accountt.getAccount());
        }
    }
    public Bank() {
    }

    public void checkPin(String account, String pin) {
        int t=0;
        for (Account accountt: accountList) {
            System.out.println(accountt.getPin() + " " + pin + " " + accountt.getAccount()+ " " +account);
            if (account.equals(accountt.getAccount()) && pin.equals(accountt.getPin())) {
                t=1;
                System.out.println("Welcome " + accountt.getOwnerFullName());
                while(true) {
                    System.out.println("Choose:\n" +
                            "1. Check balance\n" +
                            "2. With draw\n" +
                            "3. Top up\n" +
                            "4. Change PIN\n" +
                            "0. Exit");
                    int choise = in.nextInt();
                    switch (choise) {
                        case 1:
                            atm.CheckBalance(accountt);
                            break;

                        case 2:
                            atm.WithDraw(accountt);
                            break;

                        case 3:
                            atm.TopUp(accountt);
                            break;

                        case 4:
                            System.out.print("Enter new PIN: ");
                            String pin1 = in.next();
                            System.out.println("Confirm PIN: ");
                            String pin2 = in.next();
                            if (pin1.equals(pin2)) {
                                accountt.setPin(pin1);
                                System.out.println("Your PIN succesfully changed!!!");
                            } else {
                                System.out.println("ERROR");
                            }
                            break;

                        case 0:
                            return;
                    }
                }
            }
        }
        if (t==0) {
            System.out.println("Your PIN code or account is nocorrect!!!");
        }
    }
}

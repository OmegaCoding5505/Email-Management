package EmailManagement;

import java.util.Scanner;

public class EmailDriverClass {
    public static void main(String[] args) {

        System.out.print("Enter number of employees to enroll: ");
        Scanner scan = new Scanner(System.in);
        int nOfEmp = scan.nextInt();

        Email[] employee = new Email[nOfEmp];

        for (int i = 0; i < nOfEmp; i++) {
            employee[i] = new Email();
        }
        System.out.println("Thank You!");
    }
}
package EmailManagement;

import java.util.Scanner;

public class Email {
    private String firstname;
    private String lastname;
    private String fullname;
    private String password;
    private String department;
    private String email = "";
    private String altEmail = "null";
    private final int defaultPassLength = 10;
    private int mailboxCapacity = 500;
    private String companySuffix = "xyzcompany";

    public Email() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter employee first name: ");
        this.firstname = scan.nextLine();

        System.out.print("Enter employee last name: ");
        this.lastname = scan.nextLine();

        this.fullname = this.firstname + " " + this.lastname;

        this.department = setDepartment();

        this.password = setPassword(defaultPassLength);

        email = this.firstname+this.lastname+"@"+this.department+"."+companySuffix+".com";
        System.out.println(showInfo());

        int choice;
        do {
            System.out.println("""

                    Select from the following (Press 0 to exit):\s
                       1)Set Mailbox Capacity\s
                       2)Set Alternate Email\s
                       3)Change Password\s
                       4)Show Info\s""");
            choice = scan.nextInt();

            switch (choice) {
                case 1: getmailboxCapacity();
                    setMailboxCapacity(scan.nextInt());
                    break;
                case 2: getAltEmail();
                    setAltEmail(scan.next());   //Next line wont work with sout(print) will only work with sout(println)
                    break;
                case 3: getPassword();
                    setPassword(scan.next());
                    break;
                case 4: System.out.println(showInfo());
                    break;
                case 0: break;
                default: System.out.println("Invalid Input!");
            }
        }while (choice != 0);
    }

    private String setDepartment() {
        System.out.println("""

                Enter the department:\s
                   1)Sales\s
                   2)Development\s
                   3)Accounting\s
                   4)Customer Service\s
                   5)None""");
        Scanner scan = new Scanner(System.in);
        int depChoice = scan.nextInt();

        switch (depChoice) {
            case 1: return "Sales";
            case 2: return "Development";
            case 3: return "Accounting";
            case 4: return "Customer Service";
            case 5: return "";
            default: return "Invalid Input!";
        }
    }

    private String setPassword(int length) {
        String passSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int random = (int)(Math.random() * passSet.length());
            password[i] = passSet.charAt(random);
        }

        return new String (password);

    }

    public void getmailboxCapacity() {
        System.out.println("Current Mailbox Capacity is: "+mailboxCapacity+"mb");
        System.out.print("Enter the updated Mailbox Capacity: ");
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void getAltEmail() {
        System.out.println("Current Alternate Email is: "+altEmail);
        System.out.print("Enter the updated Alternate Email: ");
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public void getPassword() {
        System.out.println("Current password is: "+this.password);
        System.out.print("Enter new password (max length 10): ");
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String showInfo() {
        return "\n------------------------------------------------" +
                "\nName of the employee: "+this.fullname+
                "\nDepartment: "+this.department+
                "\nYour email is: "+email.toLowerCase()+
                "\nYour alternate email is: "+altEmail.toLowerCase()+
                "\nYour Password is: "+this.password+
                "\nMailbox Capacity is: "+mailboxCapacity+"mb"+
                "\n------------------------------------------------";
    }
}

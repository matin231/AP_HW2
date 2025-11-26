import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        UserDatabase db = new UserDatabase();
        Authentication auth = new Authentication(db);
        BankService bank = new BankService(auth, db);

        Scanner sc = new Scanner(System.in);

        while (true) {
            String cmd = sc.nextLine().trim();
            String[] p = cmd.split(" ");

            switch (p[0]) {

                case "register":
                    if (p.length == 6)
                        System.out.println(auth.register(p[1], p[2], p[3], p[4], p[5]));
                    else
                        System.out.println("Error: invalid input");
                    break;

                case "login":
                    if (p.length == 3)
                        System.out.println(auth.login(p[1], p[2]));
                    else
                        System.out.println("Error: invalid input");
                    break;

                case "show":
                    if (p.length == 2 && p[1].equals("balance"))
                        System.out.println(bank.showBalance());
                    else
                        System.out.println("Error: invalid command");
                    break;

                case "deposit":
                    System.out.println(bank.deposit(Double.parseDouble(p[1])));
                    break;

                case "withdraw":
                    System.out.println(bank.withdraw(Double.parseDouble(p[1])));
                    break;

                case "transfer":
                    System.out.println(bank.transfer(p[1], Double.parseDouble(p[2])));
                    break;

                case "logout":
                    System.out.println(auth.logout());
                    break;

                case "exit":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Error: unknown command");
            }
        }
    }
}

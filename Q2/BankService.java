public class BankService {

    private Authentication auth;
    private UserDatabase db;

    public BankService(Authentication auth, UserDatabase db) {
        this.auth = auth;
        this.db = db;
    }

    public String showBalance() {
        if (!auth.isLoggedIn())
            return "Error: You should login first.";

        return "Current balance: " + auth.getLoggedInUser().getBalance();
    }

    public String deposit(double amount) {
        if (!auth.isLoggedIn())
            return "Error: You should login first.";

        User u = auth.getLoggedInUser();
        u.setBalance(u.getBalance() + amount);

        return "Deposit successful. Current balance: " + u.getBalance();
    }

    public String withdraw(double amount) {
        if (!auth.isLoggedIn())
            return "Error: You should login first.";

        User u = auth.getLoggedInUser();

        if (u.getBalance() < amount)
            return "Error: insufficient balance.";

        u.setBalance(u.getBalance() - amount);

        return "Withdrawal successful. Current balance: " + u.getBalance();
    }

    public String transfer(String card, double amount) {
        if (!auth.isLoggedIn())
            return "Error: You should login first.";

        User sender = auth.getLoggedInUser();
        User receiver = db.getByCard(card);

        if (receiver == null)
            return "Error: invalid card number.";

        if (sender.getBalance() < amount)
            return "Error: insufficient balance.";

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        return "Transferred successfully.";
    }
}

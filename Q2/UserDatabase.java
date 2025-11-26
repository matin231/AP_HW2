import java.util.ArrayList;

public class UserDatabase {

    private ArrayList<User> users = new ArrayList<>();

    public boolean usernameExists(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username))
                return true;
        }
        return false;
    }

    public boolean cardExists(String card) {
        for (User u : users) {
            if (u.getCardNumber().equals(card))
                return true;
        }
        return false;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public User getByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username))
                return u;
        }
        return null;
    }

    public User getByCard(String card) {
        for (User u : users) {
            if (u.getCardNumber().equals(card))
                return u;
        }
        return null;
    }

    public String generateCard() {
        while (true) {
            String card = "6037";
            for (int i = 0; i < 12; i++) {
                int r = (int) (Math.random() * 10);
                card += r;
            }
            if (!cardExists(card))
                return card;
        }
    }
}

public class Authentication {

    private UserDatabase db;
    private User loggedInUser = null;

    public Authentication(UserDatabase db) {
        this.db = db;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    // ---------- Register ----------
    public String register(String username, String password, String fullName,
                           String phone, String email) {

        if (db.usernameExists(username))
            return "Error: username already exists.";

        if (!validatePhone(phone))
            return "Error: invalid phone number.";

        if (!validateEmail(email))
            return "Error: invalid email.";

        if (!validatePassword(password))
            return "Error: invalid password.";

        String card = db.generateCard();
        User user = new User(username, password, fullName, phone, email, card);
        db.addUser(user);

        return "Registered successfully. Assigned card number: " + card;
    }

    // ---------- Login ----------
    public String login(String username, String password) {
        if (isLoggedIn())
            return "Error: someone already logged in.";

        User u = db.getByUsername(username);
        if (u == null || !u.getPassword().equals(password))
            return "Error: invalid username or password.";

        loggedInUser = u;
        return "Login successful.";
    }

    public String logout() {
        if (!isLoggedIn())
            return "Error: no user is logged in.";

        loggedInUser = null;
        return "Logout successful.";
    }

    // ---------- Validators ----------
    private boolean validatePhone(String phone) {
        if (phone.length() != 11 || !phone.startsWith("09"))
            return false;
        for (int i = 0; i < phone.length(); i++)
            if (!Character.isDigit(phone.charAt(i)))
                return false;
        return true;
    }

    private boolean validateEmail(String email) {
        int at = email.indexOf('@');
        if (at <= 0) return false;
        String domain = email.substring(at + 1);
        return domain.equals("aut.com");
    }

    private boolean validatePassword(String pass) {
        if (pass.length() < 8) return false;

        boolean up = false, low = false, digit = false, spec = false;
        String specials = "@!&$؟";

        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isUpperCase(c)) up = true;
            else if (Character.isLowerCase(c)) low = true;
            else if (Character.isDigit(c)) digit = true;
            else if (specials.indexOf(c) != -1) spec = true;
        }

        return up && low && digit && spec;
    }
}

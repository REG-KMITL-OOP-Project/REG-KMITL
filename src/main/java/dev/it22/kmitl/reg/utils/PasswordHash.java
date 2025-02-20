package dev.it22.kmitl.reg.utils;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHash {
    private final String password;
    public PasswordHash(String password) {
        this.password = password;
    }

    public String hashPassword() {
        return BCrypt.hashpw(this.password, BCrypt.gensalt());
    }

    public boolean checkPassword(String hashedPassword) {
        return BCrypt.checkpw(this.password, hashedPassword);
    }
}

package data;

import lombok.*;

@Data
public class AuthData {

    private static final AuthData INSTANCE = new AuthData();
    private String userName;
    private String password;

    public static AuthData getInstance() {
        return INSTANCE;
    }

    public void clear() {
        userName = null;
        password = null;
    }
}

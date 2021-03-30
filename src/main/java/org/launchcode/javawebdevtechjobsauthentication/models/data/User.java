package org.launchcode.javawebdevtechjobsauthentication.models.data;

import com.sun.istack.NotNull;
import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User extends AbstractEntity {

        @NotNull
        private String username;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        @NotNull
        private String pwHash;

        public User() {}

        public User(String username, String password) {
            this.username = username;
            this.pwHash = encoder.encode(password);
        }

        public String getUsername() {
            return username;
        }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}


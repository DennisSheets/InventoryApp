package InventoryApp.InventoryApp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "welcome";
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println(rawPassword);
        System.out.println(encodedPassword);
    }

}

// namhm - codejava
// admin - nimha
// alex - alex

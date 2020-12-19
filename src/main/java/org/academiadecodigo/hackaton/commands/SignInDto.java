package org.academiadecodigo.hackaton.commands;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class SignInDto {

    @Email
    private String email;

    @Size(min=3, max=64, message = "Pass size must be between 3 and 64")
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

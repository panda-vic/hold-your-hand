package org.academiadecodigo.hackaton.commands;

import javax.validation.constraints.*;

public class UserDto {

    private Integer id;

    @NotNull(message = "Name is mandatory")
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^\\+?[A-Z\u00C0-\u00FF][a-zA-Z\u00C0-\u00FF ]*$", message = "Name has invalid characters")
    @Size(min=3, max=64, message = "Between 3 and 64 chars")
    private String name;

    @Email
    private String email;

    @Size(min=3, max=64, message = "Pass size must be between 3 and 64")
    private String password;

    @Pattern(regexp = "^\\+?[9][1236][0-9]*$", message = "Phone has invalid characters, prefix 9[1236]")
    @Size(min=9, max=16, message = "Between 9 and 16 numbers")
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

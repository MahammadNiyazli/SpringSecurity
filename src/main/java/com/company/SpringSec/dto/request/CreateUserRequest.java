package com.company.SpringSec.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CreateUserRequest {
    private String firstName;
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String address;
    private String pin;
    private String password;

    public CreateUserRequest(String firstName, String lastName, LocalDate birthDate, String address, String pin, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.pin = pin;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPin() {
        return pin;
    }

    public String getPassword() {
        return password;
    }
}

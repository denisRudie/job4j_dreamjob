package ru.job4j.dream.model;

public class CandidateJson {
    private String firstName;
    private String lastName;
    private String password;

    public CandidateJson(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}

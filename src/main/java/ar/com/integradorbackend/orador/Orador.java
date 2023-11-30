package ar.com.integradorbackend.orador;

import java.time.LocalDate;

/**
 * Orador
 */
public class Orador {

    Long id;
    String name;
    String lastName;
    String email;
    String theme;
    LocalDate startDate;

    // constructor with all attributes
    public Orador(Long id, String name, String lastName, String email, String theme, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.theme = theme;
        this.startDate = startDate;
    }
    // constructor without id

    public Orador(String name, String lastName, String email, String theme, LocalDate startDate) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.theme = theme;
        this.startDate = startDate;
    }

    // getter's and setter's
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Orador [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", theme="
                + theme + ", startDate=" + startDate + "]";
    }

}

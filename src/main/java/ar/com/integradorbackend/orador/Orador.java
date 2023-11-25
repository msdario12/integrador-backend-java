package ar.com.integradorbackend.orador;

import java.time.LocalDate;

/**
 * Orador
 */
public class Orador {

    String id;
    String name;
    String lastName;
    String email;
    String theme;
    LocalDate startDate;

    // constructor with all attributes
    public Orador(String id, String name, String lastName, String email, String theme, LocalDate startDate) {
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

}

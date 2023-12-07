package ar.com.integradorbackend.controllers;

/**
 * OradorRequest
 */
public class OradorRequest {
    private String firstName;
    private String lastName;
    private String mail;
    private String theme;

    public OradorRequest() {

    }

    public OradorRequest(String firstName, String lastName, String mail, String theme) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.theme = theme;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}

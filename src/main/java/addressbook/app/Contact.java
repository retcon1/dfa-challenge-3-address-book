package addressbook.app;

public class Contact {
    private String name;
    private String number;
    private String email;

    public Contact(String name, String number, String email) throws IllegalArgumentException {
        if (!Validator.validateAll(name, number, email)) throw new IllegalArgumentException("Name, Phone Number or Email is invalid");
        this.name = name;
        this.number = number;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
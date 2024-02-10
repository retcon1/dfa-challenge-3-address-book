package addressbook.app;

public class Contact {
    private String name;
    private String number;
    private String email;

    public Contact(String name, String number, String email) throws IllegalArgumentException {
        if (!Validator.validateAll(name, number, email))
            throw new IllegalArgumentException("Name, Phone Number or Email is invalid");
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!Validator.validateName(name)) throw new IllegalArgumentException("Given name is invalid!");
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (!Validator.validateNumber(number)) throw new IllegalArgumentException("Given number is invalid!");
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!Validator.validateEmail(email)) throw new IllegalArgumentException("Given email is invalid!");
        this.email = email;
    }
}
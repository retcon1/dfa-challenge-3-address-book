package addressbook.app;

import java.util.regex.Pattern;

public class Validator {
    public static boolean validateType(Object obj, Class<?> type) {
        return obj.getClass().equals(type);
    }

    public static boolean validateName(String name) {
        String nameRegex = "^[a-zA-Z]+'?-?[a-zA-Z]*\\s[a-zA-Z]+'?-?[a-zA-Z]*$";
        return Pattern.matches(nameRegex, name);
    }
    public static boolean validateEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return Pattern.matches(emailRegex, email);
    }
}

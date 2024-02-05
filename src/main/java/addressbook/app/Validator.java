package addressbook.app;

import java.util.regex.Pattern;

public class Validator {
    public static boolean validateType(Object obj, Class<?> type) {
        return obj.getClass().equals(type);
    }

}

package service.validate;

public class InputVerifier {
    public static void validateNameLength(String[] names) {
        for (String name : names) {
            checkNameLength(name);
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}

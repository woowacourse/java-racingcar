package service.validate;

public class InputVerifier {

    public static String[] splitInput(String input) {
        String[] names = input.split(",");
        validateNameLength(names);
        return names;
    }
    private static void validateNameLength(String[] names) {
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

public class Validator {
    public static void validateCarName(String name) {
        if (!name.matches("^[a-zA-Z가-힣]{1,5}$")) {
            throw new IllegalArgumentException();
        }
    }

    public static int validateCount(String rawCount) {
        isDigit(rawCount);

        int count = Integer.parseInt(rawCount);
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
        return count;
    }

    private static void isDigit(String rawCount) {
        for (int i = 0; i < rawCount.length(); i++) {
            if (!Character.isDigit(rawCount.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }
}

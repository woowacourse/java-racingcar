package carracinggame.domain;

public class CarNames {
    private static final String REGEX = ",+[\\s\\t],+|^[\\s\\t]*,.*|.*,[\\s\\t]*$";
    public static final int NAME_MAX_LENGTH = 6;
    public static final int NAME_MIN_LENGTH = 0;

    public static void checkBlank(final String checking) throws IllegalArgumentException {
        if (checking.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRightLength(String name) throws IllegalArgumentException {
        if (isRightLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isRightLength(String name) {
        return name.length() <= NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH;
    }


}

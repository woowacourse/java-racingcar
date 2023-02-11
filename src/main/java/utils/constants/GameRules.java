package utils.constants;

public enum GameRules {

    MAX_NAME_LENGTH(5),
    MOVE_NUMBER(3);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH.value) {
            throw new IllegalArgumentException(ErrorMessages.NAME_LENGTH.getMessage());
        }
    }

    public static boolean canMove(int number) {
        return number > MOVE_NUMBER.value;
    }
}

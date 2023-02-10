package utils.constants;

public enum GameRules {

    NAME_LENGTH(5),
    MOVE_NUMBER(3);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

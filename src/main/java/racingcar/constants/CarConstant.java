package racingcar.constants;

public enum CarConstant {
    NAME_MAX_LENGTH(5),
    NAME_MIN_LENGTH(0);

    private final int number;

    CarConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

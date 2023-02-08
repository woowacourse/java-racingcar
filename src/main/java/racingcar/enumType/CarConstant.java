package racingcar.enumType;

public enum CarConstant {
    FORWARD_NUMBER(4);

    private final int number;

    CarConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

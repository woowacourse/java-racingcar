package domain;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Car(String name) {
        if (!(name.length() >= MIN_NAME_LENGTH && name.length() <= MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException("이름 길이는 0~5이여야 합니다.");
        }
        this.name = name;
    }
}

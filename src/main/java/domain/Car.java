package domain;

import dto.CarStatus;

public class Car {

    public static final int INITIAL_DISTANCE = 0;
    public static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int FORWARD_NUMBER = 4;

    private final NumberRangeGenerator numberRangeGenerator;
    private final String name;

    private int distance;

    public Car(final NumberRangeGenerator numberRangeGenerator, final String name, final int distance) {
        validateCarName(name);
        this.numberRangeGenerator = numberRangeGenerator;
        this.name = name;
        this.distance = distance;
    }

    public Car(final NumberRangeGenerator numberRangeGenerator, final String name) {
        this(numberRangeGenerator, name, INITIAL_DISTANCE);
    }

    private void validateCarName(final String name) {
        final int length = name.length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 1이상 5이하의 문자열만 가능합니다.");
        }
    }

    public void move() {
        if (numberRangeGenerator == null) {
            return;
        }

        final int randomNumber = numberRangeGenerator.generateRandomNumberInRange(0, 9);

        if (randomNumber >= FORWARD_NUMBER) {
            distance++;
        }
    }

    public boolean isAtDistance(int distance) {
        return this.distance == distance;
    }

    public CarStatus getStatus() {
        return new CarStatus(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

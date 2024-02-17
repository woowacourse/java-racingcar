package domain;

import dto.CarStatus;

public class Car {

    private static final int INITIAL_DISTANCE = 0;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_NUMBER = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

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
        final int randomNumber = numberRangeGenerator.generateRandomNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
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

package domain.car;

import domain.random.RandomNumberGenerator;
import dto.CarStatus;

public class Car {

    public static final int INITIAL_DISTANCE = 0;

    private final RandomNumberGenerator randomNumberGenerator;
    private final String name;
    
    private int distance;

    public Car(final RandomNumberGenerator randomNumberGenerator, final String name, final int distance) {
        validateRandomNumberGenerator(randomNumberGenerator);
        validateCarName(name);
        this.randomNumberGenerator = randomNumberGenerator;
        this.name = name;
        this.distance = distance;
    }

    public Car(final RandomNumberGenerator randomNumberGenerator, final String name) {
        this(randomNumberGenerator, name, INITIAL_DISTANCE);
    }

    private void validateRandomNumberGenerator(final RandomNumberGenerator randomNumberGenerator) {
        if (randomNumberGenerator == null) {
            throw new IllegalArgumentException("RandomNumberGenerator가 존재하지 않습니다.");
        }
    }

    private void validateCarName(final String name) {
        int length = name.length();
        if (length < 1 || length > 5) {
            throw new IllegalArgumentException("이름 길이는 1이상 5이하의 문자열만 가능합니다.");
        }
    }

    public void move() {
        int randomNumber = randomNumberGenerator.generateRandomNumberInRange(0, 9);

        if (randomNumber >= 4) {
            distance++;
        }
    }

    public CarStatus getStatus() {
        return new CarStatus(name, distance);
    }

    public boolean isDistanceEqual(int distance) {
        return this.distance == distance;
    }

    public String getName() {
        return name;
    }
}

package domain;

import dto.CarStatus;

public class Car {

    public static final int INITIAL_DISTANCE = 0;

    private final RandomNumberGenerator randomNumberGenerator;
    private final String name;
    
    private int distance;

    public Car(RandomNumberGenerator randomNumberGenerator, final String name, final int distance) {
        validateCarName(name);
        this.randomNumberGenerator = randomNumberGenerator;
        this.name = name;
        this.distance = distance;
    }

    public Car(RandomNumberGenerator randomNumberGenerator, final String name) {
        this(randomNumberGenerator, name, INITIAL_DISTANCE);
    }

    private void validateCarName(String name) {
        int length = name.length();
        if (length < 1 || length > 5) {
            throw new RuntimeException("이름 길이는 1이상 5이하의 문자열만 가능합니다.");
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
}

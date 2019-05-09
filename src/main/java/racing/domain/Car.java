package racing.domain;

import racing.view.ConsoleMessages;

import java.util.Random;

public class Car implements Comparable<Car> {
    private static final int MAX_CAR_NAME = 5;
    private static final int MIN_MOVABLE_NUMBER = 4;
    private static final int RANDOM_NUMBER_RANGE = 10;
    private final String name;
    private int distance;


    public Car(String name) {
        this.name = checkName(name.trim());
        distance = 1;
    }

    public Car(String name, int distance) {
        this.name = checkName(name);
        this.distance = distance;
    }

    public int move() {
        if (isMove(generateRandomNumber())) {
            distance++;
        }
        return distance;
    }

    public boolean isMove(int number) {
        return number >= MIN_MOVABLE_NUMBER;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }


    private String checkName(String name) {
        if (name.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_CAR_NAME.getMessage());
        }
        return name;
    }

    public String getStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        for (int i = 0; i < distance; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public boolean isMaxDistance(Car winnerCar) {
        return this.distance == winnerCar.distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return this.distance - car.distance;
    }
}

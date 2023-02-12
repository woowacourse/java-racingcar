package model;

public class Car extends Vehicle {

    public static final int RANDOM_MOVE_BOUNDARY = 4;
    public static final int RANDOM_NUMBER_GENERATE_RANGE = 10;
    public static final int START_POSITION = 0;
    private static final int LENGTH_LOWER_BOUND = 1;
    private static final int LENGTH_UPPER_BOUND = 5;

    private final RandomGenerator randomGenerator;

    public Car(String name, RandomGenerator randomGenerator) {
        super(name, START_POSITION);
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isMove() {
        return randomGenerator.generate(RANDOM_NUMBER_GENERATE_RANGE) >= RANDOM_MOVE_BOUNDARY;
    }
}

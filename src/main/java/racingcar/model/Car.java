package racingcar.model;

public class Car {
    private final String name;
    private final NumberGenerator numberGenerator;
    private static final int MIN_MOVING_STANDARD = 4;
    private static final int RANDOM_NUMBER_BOUNDARY = 10;
    private int position;

    public Car(String name, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.name = name;
    }

    private boolean canMove() {
        int random = numberGenerator.generateNumber(RANDOM_NUMBER_BOUNDARY);
        return random >= MIN_MOVING_STANDARD;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    public boolean isFurthestPosition(int maxPosition){
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

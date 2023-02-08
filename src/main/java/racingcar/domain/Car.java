package racingcar.domain;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private final String name;
    private int currentPoint;

    public Car(String name, int startPoint) {
        this.name = name;
        this.currentPoint = startPoint;
    }

    public void move(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();
        if (isMovable(randomNumber)) {
            currentPoint++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MINIMUM_NUMBER_TO_MOVE;
    }
}

package racingcar.domain;

public class Car {

    private final String name;
    private int currentPoint;

    public Car(String name, int startPoint) {
        this.name = name;
        this.currentPoint = startPoint;
    }
}

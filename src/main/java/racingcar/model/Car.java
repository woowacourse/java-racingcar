package racingcar.model;

public class Car {
    private String name;
    private int position;

    public void move() {
        position++;
    }

    public String getName() {
        return name;
    }
}

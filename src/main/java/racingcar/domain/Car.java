package racingcar.domain;

public class Car {

    public static final int MOVE_FORWARD_NUMBER = 4;
    private final String name;
    private final int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car race(int num) {
        if (num >= MOVE_FORWARD_NUMBER) {
            return new Car(this.name, this.position + 1);
        }
        return new Car(this.name, this.position);
    }
}

package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }
    //테스트용 생성자?

    public int moveAndReturnPosition(MovementStrategy cond) {
        if (cond.isMovable()) {
            position++;
        }
        return position;
    }

    public boolean isAt(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        return name;
    }

}

package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    private void move() {
        position++;
    }

    public void drive() {
        if (hasNext()) {
            move();
        }
    }

    private boolean hasNext() {
        int moveFlag = (int) (Math.random() * 100) % 10;
        return moveFlag > 3;
    }
}

package racingcar;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    private int makeRandom() {
        return (int) (Math.random() * 10);
    }

    public boolean isMovable() {
        return makeRandom() >= 4;
    }

    public void movePosition() {
        if (isMovable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(int number) {
        return position == number;
    }
}

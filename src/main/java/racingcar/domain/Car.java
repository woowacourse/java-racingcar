package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void goOrNot(int num) {
        if (num >= 4) {
            go();
        }
    }

    private void go() {
        position += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void goOrNot(int number) {
        if (canGo(number)) {
            go();
        }
    }

    private void go() {
        position += 1;
    }

    private boolean canGo(int number) {
        return number >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

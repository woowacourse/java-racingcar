package racingcar;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrHold(Boolean isMove) {
        if (isMove) {
            this.position += 1;
        }
    }

    public void moveOrHold() {

    }
}

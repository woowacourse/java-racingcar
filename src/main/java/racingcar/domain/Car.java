package racingcar.domain;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public void move(boolean isMoving) {
        if (isMoving) {
            position++;
        }
    }

    public String toString() {
        return this.name + " : " + repeat("-", this.position);
    }

    private String repeat(String str, int num) {
        return new String(new char[num]).replace("\0", str);
    }
}

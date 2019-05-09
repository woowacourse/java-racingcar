package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position++;
    }

    public void randomForward(boolean isMove) {
        if (isMove) {
            this.moveForward();
        }
    }

    @Override
    public String toString() {
        return this.name + " : " + "-".repeat(this.position);
    }
}

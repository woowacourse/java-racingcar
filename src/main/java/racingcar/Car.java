package racingcar;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    private void accelerate() {
        position++;
    }

    public void drive(int randomValue) {
        if (randomValue >= 4) {
            accelerate();
        }
    }
}

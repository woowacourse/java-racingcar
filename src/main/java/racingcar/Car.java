package racingcar;

import java.util.stream.IntStream;

public class Car {

    private int position;
    private String name;

    public Car() {
        this.position = 0;
    }

    public void drive(int randomValue) {
        if (randomValue < 0 || randomValue > 9) {
            throw new RuntimeException();
        }

        if (randomValue >= 4) {
            accelerate();
        }
    }

    public int getPosition() {
        return position;
    }

    private void accelerate() {
        position++;
    }

    @Override
    public String toString() {
        String a = name + " : ";
        return a + getPositionToString();
    }

    private String getPositionToString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, position)
                .forEach(i -> sb.append("-"));
        return sb.toString();
    }
}

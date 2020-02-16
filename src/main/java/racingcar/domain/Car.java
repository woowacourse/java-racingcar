package racingcar.domain;

public class Car {
    private static final int START_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = START_POSITION;
    }

    public void move(RandomNumber RandomNumber) {
        if (RandomNumber.isMove()) {
            position++;
        }
    }

    public boolean isWinner(int winnerPosition) {
        return winnerPosition == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

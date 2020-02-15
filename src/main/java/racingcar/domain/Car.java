package racingcar.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final int MAX_LENGTH_OF_NAME = 5;
    private CarName name;
    private int position;

    public Car(CarName name) {
        // if (name.length() > MAX_LENGTH_OF_NAME) {
        //     throw new IllegalArgumentException("자동차 이름은 5글자 이하로만 입력가능합니다.");
        // }
        this.name = name;
        position = INITIAL_POSITION;
    }

    public void move(RandomNo number) {
        if (number.isMovable()) {
            position++;
        }
    }

    boolean isWinner(int winnerPosition) {
        return winnerPosition == position;
    }

    int getPosition() {
        return position;
    }

    String getName() {
        return name.getName();
    }

    @Override
    public String toString() {
        StringBuilder trace = new StringBuilder();
        for (int i = 0; i < position; i++) {
            trace.append("-");
        }

        return name + ": " + trace.toString();
    }

}

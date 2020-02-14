package racingcar.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = INITIAL_POSITION;
    }

    public void move(RandomNo randomNumber) {
        if (randomNumber.isMovable()) {
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

    @Override
    public String toString() {
        StringBuilder trace = new StringBuilder();
        for (int i = 0; i < position; i++) {
            trace.append("-");
        }

        return name + ": " + trace.toString();
    }

}

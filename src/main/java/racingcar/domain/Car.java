package racingcar.domain;

public class Car {

    private final String name;
    private int position;

    private static final int GO_CRITERIA = 4;
    private static final int INITIAL_POSITION = 0;

    public Car(String name) {
        this.name = name;
        position = INITIAL_POSITION;
    }

    public void oneTurn(int randomTurnNumber) {
        if (randomTurnNumber >= GO_CRITERIA) {
            progressPosition();
        }
    }

    private void progressPosition() {
        this.position++;
    }

    public boolean isSamePosition(int targetPosition) {
        return this.position == targetPosition;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
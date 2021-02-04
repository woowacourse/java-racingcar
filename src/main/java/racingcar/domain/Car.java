package racingcar.domain;

public class Car {
    private String name;
    private int position;

    private static final int GO_CRITERIA = 4;
    private static final int INITIAL_POSITION = 0;

    public Car(String name) {
        name = this.name;
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

    public int getPosition() {
        return this.position;
    }
}
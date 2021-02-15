package racingcar.domain;

public class Car {

    private final Name name;
    private Position position;

    private static final int GO_CRITERIA = 4;

    public Car(String name) {
        this.name = new Name(name);
        position = new Position();
    }

    public void oneTurn(int randomTurnNumber) {
        if (randomTurnNumber >= GO_CRITERIA) {
            progressPosition();
        }
    }

    private void progressPosition() {
        Position carPosition = this.position;
        carPosition.progressOneTurn();
    }

    public boolean isSamePosition(int targetPosition) {
        Position carPosition = this.position;
        return carPosition.isSameValue(targetPosition);
    }

    public String getName() {
        Name carName = this.name;
        return carName.getValue();
    }

    public int getPosition() {
        Position carPosition = this.position;
        return carPosition.getValue();
    }
}
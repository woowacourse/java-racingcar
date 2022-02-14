package racingcar.model;

public class Car {
    private static final int MOVING_DISTANCE = 1;
    private static final int STANDARD_VALUE = 4;
    private static final String DISTANCE_MARK = "-";

    private final Name name;
    private final Position position;

    public Car(String nameString) {
        this.name = new Name(nameString);
        this.position = new Position();
    }

    public void goOrStop(int random) {
        if (random >= STANDARD_VALUE) {
            position.move(MOVING_DISTANCE);
        }
    }

    public String getName() {
        return this.name.toString();
    }

    public int getPosition() {
        return this.position.toInt();
    }

    public String getCarStatus() {
        String carPositionString = getGaugeBar(getPosition());
        return getName() + " : " + carPositionString;
    }

    private String getGaugeBar(int cnt) {
        return DISTANCE_MARK.repeat(Math.max(0, cnt));
    }
}

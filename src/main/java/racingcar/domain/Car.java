package racingcar.domain;

import racingcar.domain.utils.RandomUtils;

public class Car {
    private static final int MINIMUM_TO_MOVE = 4;

    private final Name name;

    private int position = 0;

    private Car(final Name name) {
        this.name = name;
    }

    public static Car createByName(final Name name) {
        return new Car(name);
    }

    public int getFatherPosition(int position) {
        return Math.max(this.position, position);
    }

    public boolean isOnPosition(int position) {
        return position == this.position;
    }

    public void tryToMove(int number) {
        if (number >= MINIMUM_TO_MOVE) {
            position++;
        }
    }

    public RaceResultDTO getRaceResults() {
        return new RaceResultDTO(name, position);
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof Car) {
            return this.name.equals(((Car) o).name);
        }
        return false;
    }
}

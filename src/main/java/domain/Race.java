package domain;

import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Race {
    private List<Car> carsOnRace;
    private int roundCount;
    private StringBuilder stringBuilder;

    public Race(List<Car> carsOnRace, int roundCount) {
        this.carsOnRace = carsOnRace;
        this.roundCount = roundCount;
        this.stringBuilder = new StringBuilder();
    }

    public List<Car> moveAllCarsByRoundCount() {
        for (int i = 0; i < roundCount; i++) {
            stringBuilder.append(moveAllCarsByOneTime());
            stringBuilder.append("\n");
        }
        return carsOnRace;
    }

    private String moveAllCarsByOneTime() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carsOnRace) {
            car.increasePositionOrNot(Util.getRandomNumber());
            sb.append(car.toString());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return roundCount == race.roundCount &&
                Objects.equals(carsOnRace, race.carsOnRace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsOnRace, roundCount);
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}

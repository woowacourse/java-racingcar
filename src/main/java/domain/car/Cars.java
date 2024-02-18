package domain.car;

import domain.name.Names;
import domain.race.RaceProgress;
import util.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> value;

    public Cars(List<Car> cars) {
        this.value = cars;
    }

    public static Cars from(Names names) {

        List<Car> cars = names.getNames()
                              .stream()
                              .map(Car::new)
                              .toList();

        return new Cars(cars);
    }

    public List<Car> getMaxPositionCars() {
        Integer maxPosition = getMaxPosition();
        return selectCarsWithPosition(maxPosition);
    }

    public List<RaceProgress> performRace(int raceCount, NumberGenerator powerGenerator) {
        return IntStream.range(0, raceCount)
                        .mapToObj(index -> performEachRace(powerGenerator)).toList();
    }

    private RaceProgress performEachRace(NumberGenerator powerGenerator) {
        value.forEach(car -> car.race(powerGenerator.generate()));
        return RaceProgress.from(value);
    }


    private Integer getMaxPosition() {
        return value.
                stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> selectCarsWithPosition(Integer position) {
        return value
                .stream()
                .filter(car -> car.isAtPosition(position))
                .toList();
    }


    public List<Car> getValue() {
        return Collections.unmodifiableList(value);
    }
}

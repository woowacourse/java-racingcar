package domain.race;

import domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceProgress {
    private final List<RaceCarInfo> raceCarInfos;

    private RaceProgress(List<RaceCarInfo> raceCarInfos) {
        this.raceCarInfos = raceCarInfos;
    }

    public static RaceProgress from(final List<Car> cars) {
        return new RaceProgress(cars
                .stream()
                .map(RaceCarInfo::from)
                .toList()
        );
    }

    @Override
    public String toString() {
        return raceCarInfos
                .stream()
                .map(RaceCarInfo::toString)
                .collect(Collectors.joining("\n", "", "\n"));
    }
}

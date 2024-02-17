package domain.race;

import domain.car.Car;

import java.util.List;

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

    public List<RaceCarInfo> getRaceCarInfo() {
        return raceCarInfos;
    }
}

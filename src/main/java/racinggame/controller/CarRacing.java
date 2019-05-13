package racinggame.controller;

import racinggame.domain.Car;
import racinggame.domain.LeagueHistory;
import racinggame.domain.TrialHistory;

import java.util.List;
import java.util.Objects;

public class CarRacing {
    private List<Car> cars;
    private final int totalTrial;

    public CarRacing(final List<Car> cars, final int totalTrial) {
        this.cars = cars;
        this.totalTrial = totalTrial;
    }

    public CarRaceResult raceStart(RunCondition runCondition) {
        LeagueHistory leagueHistory = new LeagueHistory();

        for (int trial = 1; trial <= totalTrial; trial++) {
            cars.forEach(car -> car.run(runCondition.runOrStop()));
            leagueHistory.record(trial, new TrialHistory(cars));
        }
        return new CarRaceResult(leagueHistory, totalTrial);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRacing carRacing = (CarRacing) o;
        return totalTrial == carRacing.totalTrial &&
                Objects.equals(cars, carRacing.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, totalTrial);
    }
}

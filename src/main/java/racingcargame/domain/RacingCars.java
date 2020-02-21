package racingcargame.domain;

import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import racingcargame.domain.EachRaceResult;
import racingcargame.domain.MovingConditionGenerator;
import racingcargame.domain.car.Car;
import racingcargame.domain.car.CarDto;
import racingcargame.domain.car.Name;
import racingcargame.domain.car.Position;

public class RacingCars {
    private List<Car> racingCars;
    private static final int NUMBER_RANGE = 10;

    public RacingCars(List<Name> names) {
        List<Car> newRacingCars = new ArrayList<>();
        for (Name name : names) {
            newRacingCars.add(new Car(name));
        }
        this.racingCars = newRacingCars;
    }

    List<Car> getRacingCars() {
        return racingCars;
    }

    public EachRaceResult processOneRace(MovingConditionGenerator movingConditionGenerator) {
        EachRaceResult eachRaceResult = new EachRaceResult();
        for (Car car : racingCars) {
            car.decideGoOrStop(movingConditionGenerator.createRandomNumber());
            eachRaceResult.addCarDto(new CarDto(car.getName(), car.getPosition().getNumber()));
        }
        return eachRaceResult;
    }

    private int createRandomNumber() {
        return (int)(Math.random() * NUMBER_RANGE);
    }

    public List<Car> getWinners() {
        int maxPosition = racingCars
            .stream()
            .map(Car::getPosition)
            .map(Position::getNumber)
            .sorted(reverseOrder())
            .findFirst().orElse(0);
        List<Car> winnerCar = racingCars.stream()
            .filter(car -> car.getPosition().getNumber() == maxPosition)
            .collect(Collectors.toList());
        return winnerCar;
    }
}

package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.numberGenerator.NumberGenerator;
import racingcar.util.CarMakerUtil;
import racingcar.view.ErrorMessage;

public class Cars {

    private final List<Car> cars;
    private final RaceResult raceResult;

    public Cars(String[] names) {
        cars = CarMakerUtil.createCarsWith(names);
        raceResult = new RaceResult();
    }

    private Cars(List<Car> cars, String raceAllResult) {
        this.cars = new ArrayList<>(cars);
        this.raceResult = new RaceResult(raceAllResult);
    }

    public Cars repeatRaceBy(Attempt attempt, NumberGenerator numberGenerator) {
        StringBuilder raceResultBuilder = new StringBuilder();
        List<Car> cars = new ArrayList<>(this.cars);
        while (attempt.isLeft()) {
            cars = raceAll(cars, numberGenerator);
            raceResultBuilder.append(getOnceResultWith(cars));
            attempt = attempt.decrease();
        }
        return new Cars(cars, raceResultBuilder.toString());
    }

    public Winners judgeWinners() {
        Car maxPositionCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoSuchElementException(ErrorMessage.CAR_NOT_FOUND.getMessage()));
        return new Winners(cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .collect(Collectors.toList()));
    }

    public boolean isSameSize(int size) {
        return cars.size() == size;
    }

    private List<Car> raceAll(List<Car> cars, NumberGenerator numberGenerator) {
        List<Car> afterRaceCars = new ArrayList<>();
        for (Car car : cars) {
            Car movedCar = car.move(numberGenerator.generate());
            afterRaceCars.add(movedCar);
        }
        return afterRaceCars;
    }

    private String getOnceResultWith(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString());
            stringBuilder.append(System.lineSeparator());
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public RaceResult getRaceResult() {
        return raceResult;
    }
}

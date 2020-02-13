package racingcargame.domain;

import com.sun.tools.internal.ws.wsdl.document.Output;
import racingcargame.util.Spliter;
import racingcargame.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> cars = new ArrayList<>();

    public RacingCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public void move() {
        cars.forEach(car -> car.go(Engine.createRandomEngine()));
    }

    public List<Car> extractWinners() {
        Collections.sort(cars);
        Car firstScoreCar = cars.get(cars.size() - 1);
        List<Car> winners = cars.stream()
                .filter(car -> car.isSameToPosition(firstScoreCar))
                .collect(Collectors.toList());
        return Collections.unmodifiableList(winners);
    }

    public List<Car> getUnmodifiableCars() {
        return Collections.unmodifiableList(cars);
    }

    public static RacingCars createRacingCars(String inputCarNames) {
        String[] splitedInputCarNames = Spliter.split(inputCarNames);
        List<Car> cars = new ArrayList<>();
        for (String inputCarName : splitedInputCarNames) {
            cars.add(new Car(inputCarName));
        }
        return new RacingCars(cars);
    }
}

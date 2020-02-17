package racinggame.domain;

import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static racinggame.domain.RacingGame.generateRandom;

public class Cars {
    private List<Car> cars;
    private int maxPosition = 0;

    public Cars(List<String> names) {
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, 0));
        }
    }

    public void moveAllCars() {
        for (Car car : cars) {
            if (moveEachCar(car)) {
                maxPosition = car.getMaxPosition(maxPosition);
            }
            OutputView.printEachCarLog(car);
        }
        OutputView.printLine();
    }

    public boolean moveEachCar(Car car) {
        return car.move(generateRandom());
    }

    public Winners makeWinners() {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isSamePosition(maxPosition)) {
                winners.add(car);
            }
        }
        return new Winners(winners);
    }
}

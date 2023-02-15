package racing.domain;

import racing.util.Finder;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final int tryCount;

    public RacingGame(List<String> names, int inputCount) {
        this.cars = createCars(names);
        this.tryCount = inputCount;
    }

    private Cars createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String carName : names) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public void move() {
        cars.updateCarsState();
    }

    public String findWinners() {
        int winnerStep = Finder.findMaxStep(cars);
        return String.join(", ", findWinner(winnerStep));
    }

    private List<String> findWinner(int winnerStep) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            compareToWinner(winners, car, winnerStep);
        }
        return winners;
    }

    private void compareToWinner(List<String> winners, Car car, int winnerStep) {
        if (car.getStep() == winnerStep) {
            winners.add(car.getName());
        }
    }

    public Cars getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}

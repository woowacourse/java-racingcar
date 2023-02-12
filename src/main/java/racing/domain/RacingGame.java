package racing.domain;

import racing.domain.Car;
import racing.domain.Cars;
import racing.util.Finder;
import racing.view.output.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final int tryCount;


    public RacingGame(String[] names, int tryCount) {
        this.cars = createCars(names);
        this.tryCount = tryCount;
    }

    private Cars createCars(String[] names) {
        final List<Car> cars = new ArrayList<>();
        for (String carName : names) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    public void move() {
        cars.updateCarsState();
    }

    public static void printResult(Cars cars) {
        int winnerStep = Finder.findMaxStep(cars);
        StringBuilder winnersWithComma = findWinners(cars, winnerStep);
        OutputView.printFinalResult(commaRemover(winnersWithComma));
    }

    private static StringBuilder findWinners(Cars cars, int winnerStep) {
        StringBuilder sb = new StringBuilder();
        cars.addWinner(winnerStep, sb);
        return sb;
    }

    private static StringBuilder commaRemover(StringBuilder sb) {
        sb.deleteCharAt(sb.toString().length() - 1);
        sb.deleteCharAt(sb.toString().length() - 1);
        return sb;
    }

    public Cars getCars() {
        return cars;
    }
    public int getTryCount() {
        return tryCount;
    }
}

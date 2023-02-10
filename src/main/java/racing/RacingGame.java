package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.util.Finder;
import racing.view.output.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public Cars createCars(String[] names) {
        return new Cars(getCars(names));
    }

    private List<Car> getCars(String[] names) {
        final List<Car> cars = new ArrayList<>();
        for (String carName : names) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void move(Cars cars) {
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

}

package controller;

import domain.Car;
import domain.Cars;
import domain.Count;
import domain.Judge;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRaceStarter {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Judge judge = new Judge();

    public void start() {
        Cars cars = makeCars();
        Count count = makeCount();

        raceStart(cars, count);

        List<Car> winners = judge.getWinners(cars);
        outputView.printWinners(winners);
    }

    private Cars makeCars() {
        try {
            outputView.printInputCarNamesMessage();
            List<String> carNames = getCarNames();
            return collectCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return makeCars();
    }

    private Cars collectCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    private List<String> getCarNames() {
        String userInput = inputView.getUserInput();
        return Arrays.stream(userInput.split(",")).toList();
    }

    private Count makeCount() {
        try {
            outputView.printInputCountMessage();
            int count = Integer.parseInt(inputView.getUserInput());
            return new Count(count);
        } catch (IllegalArgumentException e) {
            System.out.println("1~100 사이로 입력해주세요.");
        }
        return makeCount();
    }

    private void raceStart(Cars cars, Count count) {
        outputView.printMoveResultMessage();
        while (count.hasCount()) {
            cars.moveCars();
            count.minusOneCount();
            outputView.printMoveResult(cars);
        }
    }
}

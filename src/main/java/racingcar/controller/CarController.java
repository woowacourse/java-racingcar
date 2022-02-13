package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private Count count;
    private Cars cars;

    public void run() {
         cars = generateCars();
         count = getCountFromUser();

        playGame();
        showResult();
    }

    private void showResult() {
        OutputView.printWinners(cars.findWinners());
    }

    private Cars generateCars() {
        try {
            return new Cars(InputView.getCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateCars();
        }
    }

    private void playGame() {
        OutputView.printResult(cars.get());
        for (int i = 0; i < count.getInt(); i++) {
            cars.playRound();
            OutputView.printResult(cars.get());
        }
    }

    private Count getCountFromUser() {
        try {
            return new Count(InputView.getCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCountFromUser();
        }
    }
}

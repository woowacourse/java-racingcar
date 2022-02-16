package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class CarController {

    private final InputView inputView;

    public CarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<Car> cars = makeCars(getCarNamesFromUser());
        int count = getCountFromUser();

        RacingGame racingGame = new RacingGame(cars, count);

        OutputView.printCurrentStatus(racingGame.getCars());
        while (!racingGame.isGameFinished()) {
            racingGame.playRound();
            OutputView.printCurrentStatus(racingGame.getCars());
        }

        OutputView.printWinners(racingGame.findWinners());
    }

    private List<Car> makeCars(List<String> names) {
        return names.stream()
                .map(Car::new)
                .collect(toList());
    }

    private int getCountFromUser() {
        try {
            return inputView.getCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCountFromUser();
        }
    }

    private List<String> getCarNamesFromUser() {
        try {
            return inputView.getCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNamesFromUser();
        }
    }
}

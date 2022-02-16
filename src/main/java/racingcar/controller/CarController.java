package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class CarController {
    public void run() {
        List<Car> cars = makeCars(getCarNamesFromUser());
        int count = getCountFromUser();

        RacingGame racingGame = new RacingGame(cars, count);

        OutputView.printResult(racingGame.getCars());
        while (!racingGame.isGameFinished()) {
            racingGame.playRound();
            OutputView.printResult(racingGame.getCars());
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
            return InputView.getCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCountFromUser();
        }
    }

    private List<String> getCarNamesFromUser() {
        try {
            return InputView.getCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNamesFromUser();
        }
    }
}

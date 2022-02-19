package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.utils.Validator;
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
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(toList());
        Validator.validateCarFollowsRule(cars);
        return cars;
    }

    private int getCountFromUser() {
        int count = inputView.getCount();
        Validator.validateRange(count);
        return count;
    }

    private List<String> getCarNamesFromUser() {
        return inputView.getCarNames();
    }
}

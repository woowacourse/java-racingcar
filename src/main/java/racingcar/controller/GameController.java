package racingcar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final List<Car> carGroup = new ArrayList<>();
    private final List<Car> winnerGroup = new ArrayList<>();
    private String[] names;
    private int moveCount;

    public void init() throws IOException {
        readCarNames();
        readMoveCount();
        initCars(names);
    }

    private void readCarNames() throws IOException {
        boolean nameInput = false;
        while (!nameInput) {
            nameInput = getCarNames();
        }
    }

    private boolean getCarNames() throws IOException {
        try {
            names = InputView.inputNames();
            Validator.validateCarName(names);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return false;
        }
        return true;
    }

    private void readMoveCount() throws IOException {
        boolean moveCountInput = false;
        while (!moveCountInput) {
            moveCountInput = getMoveCount();
        }
    }

    private boolean getMoveCount() throws IOException {
        try {
            moveCount = InputView.inputMoveCount();
            Validator.validateMoveCount(moveCount);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return false;
        }
        return true;
    }

    private void initCars(String[] carNames) {
        for (String name : carNames) {
            carGroup.add(new Car(name));
        }
    }

    public void play() {
        OutputView.printResultDescription();
        for (int i = 0; i < moveCount; i++) {
            doRound();
        }

        int max = findMaxPosition(carGroup);
        finish(carGroup, max);
    }

    private void doRound() {
        for (Car car : carGroup) {
            car.move(RandomNumberGenerator.generate());
            OutputView.printPosition(car);
        }
        OutputView.println();
    }

    private int findMaxPosition(List<Car> carGroup) {
        return carGroup.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private void finish(List<Car> carGroup, int max) {
        if (max == 0) {
            OutputView.printNoWinner();
            return;
        }

        carGroup.stream()
                .filter(car -> car.getPosition() == max)
                .forEach(winnerGroup::add);

        OutputView.printWinnerList(winnerGroup);
    }
}

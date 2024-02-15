package racingcar.controller;

import java.io.IOException;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final CarGroup carGroup = new CarGroup();
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
            carGroup.race();
            OutputView.printPosition(carGroup);

        }
    }

    public void finish() {
        List<Car> winners = carGroup.findWinners();
        if (winners.isEmpty()) {
            OutputView.printNoWinner();
            return;
        }

        OutputView.printWinnerList(winners);
    }
}

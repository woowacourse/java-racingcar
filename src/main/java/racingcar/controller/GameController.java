package racingcar.controller;

import java.io.IOException;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.utils.NameParser;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final CarGroup carGroup = new CarGroup();
    private List<String> names;
    private int moveCount;

    public void init() throws IOException {
        readCarNames();
        readMoveCount();
        initCars(names);
    }

    private void readCarNames() throws IOException {
        boolean isValid = false;
        while (!isValid) {
            isValid = doReadCarNames();
        }
    }

    private boolean doReadCarNames() throws IOException {
        try {
            OutputView.printlnInputName();
            names = NameParser.parse(InputView.inputNames());
            InputValidator.validateCarName(names);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return false;
        }
        return true;
    }

    private void readMoveCount() throws IOException {
        boolean isValid = false;
        while (!isValid) {
            isValid = doReadMoveCount();
        }
    }

    private boolean doReadMoveCount() throws IOException {
        try {
            OutputView.printlnInputMoveCount();
            moveCount = InputView.inputMoveCount();
            InputValidator.validateMoveCount(moveCount);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return false;
        }
        return true;
    }

    private void initCars(List<String> carNames) {
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

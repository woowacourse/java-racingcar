package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.utils.NameParser;
import racingcar.utils.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final CarGroup carGroup = new CarGroup();
    private List<String> names;
    private int moveCount;

    public void init() {
        readCarNames();
        readMoveCount();
        initCars(names);
    }

    private void readCarNames() {
        boolean nameInput = false;
        while (!nameInput) {
            nameInput = getCarNames();
        }
    }

    private boolean getCarNames() {
        try {
            OutputView.printlnInputName();
            names = NameParser.parse(InputView.inputNames());
            Validator.validateCarName(names);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return false;
        }
        return true;
    }

    private void readMoveCount() {
        boolean moveCountInput = false;
        while (!moveCountInput) {
            moveCountInput = getMoveCount();
        }
    }

    private boolean getMoveCount() {
        try {
            OutputView.printlnInputMoveCount();
            moveCount = InputView.inputMoveCount();
            Validator.validateMoveCount(moveCount);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
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

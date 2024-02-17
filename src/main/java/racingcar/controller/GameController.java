package racingcar.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.utils.NameParser;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final CarGroup carGroup = new CarGroup();
    private int moveCount;

    public void init() throws IOException {
        List<String> names;

        do {
            names = readCarNames();
        } while (!isNameValid(names));
        initCars(names);

        do {
            moveCount = readMoveCount();
        } while (!isMoveCountValid(moveCount));
    }

    private List<String> readCarNames() throws IOException {
        OutputView.printlnInputName();
        return NameParser.parse(InputView.inputNames());
    }

    private boolean isNameValid(List<String> names) {
        try {
            InputValidator.validateCarName(names);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean isMoveCountValid(int moveCount) {
        try {
            InputValidator.validateMoveCount(moveCount);
        } catch (IllegalArgumentException e) {
            OutputView.printException(e.getMessage());
            return false;
        }
        return true;
    }

    private int readMoveCount() throws IOException {
        OutputView.printlnInputMoveCount();
        return InputView.inputMoveCount();
    }

    private void initCars(List<String> carNames) {
        for (String name : carNames) {
            carGroup.add(new Car(name));
        }
    }

    public void play() {
        OutputView.printResultDescription();
        for (int i = 0; i < moveCount; i++) {
            Map<String, Integer> raceResponse = carGroup.race();
            OutputView.printPosition(raceResponse);
        }
    }

    public void finish() {
        List<String> winners = carGroup.findWinners();
        if (winners.isEmpty()) {
            OutputView.printNoWinner();
            return;
        }

        OutputView.printWinnerList(winners);
    }
}

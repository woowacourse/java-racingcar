package racingcar.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.CarGroup;
import racingcar.model.RacingGame;
import racingcar.utils.NameParser;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private RacingGame racingGame;

    public void init() throws IOException {
        List<String> names;
        int moveCount;

        do {
            names = readCarNames();
        } while (!isNameValid(names));
        do {
            moveCount = readMoveCount();
        } while (!isMoveCountValid(moveCount));

        racingGame = new RacingGame(createCarGroup(names), moveCount);
    }

    private List<String> readCarNames() throws IOException {
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
        return InputView.inputMoveCount();
    }

    private CarGroup createCarGroup(List<String> carNames) {
        CarGroup carGroup = new CarGroup();

        for (String name : carNames) {
            carGroup.add(new Car(name));
        }
        return carGroup;
    }

    public void play() {
        OutputView.printResultDescription();
        List<Map<String, Integer>> raceResponse = racingGame.race();
        OutputView.printPosition(raceResponse);
    }

    public void finish() {
        List<String> winners = racingGame.findWinners();
        if (winners.isEmpty()) {
            OutputView.printNoWinner();
            return;
        }

        OutputView.printWinnerList(winners);
    }
}

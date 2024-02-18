package controller;

import java.util.List;
import model.Race;
import utils.InputStringParser;
import utils.TryCountValidator;
import view.InputView;
import view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startRace() {
        Race race = getRace();
        int tryCount = getTryCount();

        outputView.printResultMessage();
        proceedRound(race, tryCount);
        outputView.printWinners(race);
    }

    private void proceedRound(Race race, int tryCount) {
        for (int round = 0; round < tryCount; round++) {
            race.start();
            outputView.printRoundResult(race);
        }
    }

    private Race getRace() {
        try {
            List<String> carNames = InputStringParser.parseInputToList(inputView.inputCarName());
            return new Race(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRace();
        }
    }

    private int getTryCount() {
        try {
            String tryCount = inputView.inputTryCount();
            TryCountValidator.validateTryCountFormat(tryCount);
            return Integer.parseInt(tryCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }
    }
}

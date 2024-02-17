package controller;

import model.Race;
import view.OutputView;

public class RaceController {
    private final InputController inputController;
    private final OutputView outputView;

    public RaceController() {
        this.inputController = new InputController();
        this.outputView = new OutputView();
    }

    public void startRace() {
        Race race = inputController.getRace();
        int tryCount = inputController.getTryCount();

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
}

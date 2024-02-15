package controller;

import static view.OutputView.showRaceResult;
import static view.OutputView.showRoundResult;
import static view.OutputView.showWinners;

import model.Race;

public class RaceController {

    private final InputController inputController;

    public RaceController() {
        this.inputController = new InputController();
    }

    public void startRace() {
        Race race = inputController.makeRace();
        int tryCount = inputController.makeTryCount();

        showRaceResult();
        proceedRound(tryCount, race);
        showWinners(race);
    }

    private static void proceedRound(int tryCount, Race race) {
        for (int round = 0; round < tryCount; round++) {
            race.oneGame();
            showRoundResult(race);
        }
    }
}

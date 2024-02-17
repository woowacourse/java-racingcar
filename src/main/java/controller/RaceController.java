package controller;


import model.Race;
import view.OutputView;

public class RaceController {

    private final InputController inputController;

    public RaceController() {
        this.inputController = new InputController();
    }

    public void startRace() {
        Race race = inputController.makeRace();
        int tryCount = inputController.makeTryCount();

        OutputView.showRaceResult();
        proceedRound(tryCount, race);
        OutputView.showWinners(race);
    }

    private static void proceedRound(int tryCount, Race race) {
        for (int round = 0; round < tryCount; round++) {
            race.oneGame();
            OutputView.showRoundResult(race);
        }
    }
}

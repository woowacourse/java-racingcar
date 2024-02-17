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
        runOneRound(tryCount, race);
        OutputView.showWinners(race.selectWinners());
    }

    private void runOneRound(int tryCount, Race race) {
        for (int round = 0; round < tryCount; round++) {
            race.oneGame();
            OutputView.showRoundResult(race.getCarsName(), race.getDistances());
        }
    }
}

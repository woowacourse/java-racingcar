package controller;

import model.Race;
import view.OutputView;

public class RaceController {

    private final InputController inputController;

    public RaceController() {
        this.inputController = new InputController();
    }

    public void process() {
        Race race = inputController.makeRace();
        int tryNumber = inputController.makeTryNumber();

        OutputView.showRaceResult();
        for (int i = 0; i < tryNumber; i++) {
            race.oneGame();
            OutputView.showRoundResult(race);
        }

        OutputView.showWinners(race);
    }
}

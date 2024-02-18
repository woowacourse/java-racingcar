package controller;


import model.Cars;
import model.Race;
import model.Round;
import view.InputView;
import view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRace() {
        Race race = makeRace();
        Round round = makeTryCount();

        outputView.showRaceResult();
        startRound(round, race);
        outputView.showWinners(race.selectWinners());
    }

    private Race makeRace() {
        try {
            String carNames = inputView.inputCarName();
            Cars cars = new Cars(carNames);

            return new Race(cars);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return makeRace();
        }
    }

    private Round makeTryCount() {
        try {
            String inputRound = inputView.inputRound();

            return new Round(inputRound);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return makeTryCount();
        }
    }

    private void startRound(Round round, Race race) {
        for (int i = 0; i < round.getRound(); i++) {
            race.startRound();
            outputView.showRoundResult(race.getCarsName(), race.getDistances());
        }
    }
}

package racing.control;

import racing.domain.Race;
import racing.domain.RaceResult;
import racing.view.InputView;
import racing.view.OutputView;

public class RaceOperator {
    private static Race race;
    private int numTrials;

    public void setupGame() {
        race = new Race();
        race.createCars();
        numTrials = inputNumTrials();
    }

    private int inputNumTrials() {
        try {
            OutputView.printTrialRequest();
            numTrials = InputView.requestNaturalNumber();
            return numTrials;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputNumTrials();
        }
    }

    public void startGame() {
        repeatRace(numTrials);
        OutputView.printRace(race);
    }

    private void repeatRace(int numTrials) {
        OutputView.printResultMessage();
        for (int i = 0; i < numTrials; i++) {
            race.progressRace();
            OutputView.printRace(race);
            OutputView.printNewLine();
        }
    }

    public void endGame() {
        RaceResult result = race.getResult();
        OutputView.printResult(result);
    }
}

package racing.control;

import racing.domain.Race;
import racing.domain.RaceResult;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RaceOperator {
    private static Race race;
    private int numTrials;

    public RaceOperator() {
        numTrials = InputView.inputNumTrials();
        race = new Race(numTrials);
    }

    public void startGame() {
        race.repeatRace();
        OutputView.printProgressMessage(race);
    }

    public void endGame() {
        RaceResult result = race.getResult();
        OutputView.printResult(result);
    }
}

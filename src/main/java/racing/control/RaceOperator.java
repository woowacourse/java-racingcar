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

    public void setupGame() {
        race = new Race();
        setupCars(race);
        numTrials = inputNumTrials();
    }

    private void setupCars(Race race) {
        try {
            race.createCars(inputCarNames());
        } catch (Exception e) {
            OutputView.printErrMsg(e.getMessage());
            setupGame();
        }
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

    private List<String> inputCarNames() {
        try {
            List<String> carNames = InputView.requestNames();
            checkDuplicatedNames(carNames);
            return carNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    private boolean checkDuplicatedNames(final List<String> names) {
        List<String> reducedNames = names.stream().distinct().collect(Collectors.toList());
        if (names.size() != reducedNames.size()) throw new IllegalArgumentException("중복된 이름이 존재하면 안됩니다.");
        return true;
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

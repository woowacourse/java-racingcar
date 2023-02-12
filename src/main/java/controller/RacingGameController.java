package controller;

import domain.Name;
import domain.RacingCar;
import domain.RacingCars;
import domain.TryCount;
import exception.NotPositiveIntegerException;
import view.InputView;
import view.OutputView;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGameController {

    private RacingCars racingCars;
    private TryCount tryCount;

    public void start() {
        setUpGame();
        playGame();
    }

    private void setUpGame() {
        racingCars = createRacingCar();
        tryCount = getTryCount();
    }

    private RacingCars createRacingCar() {
        final List<Name> names = inputCarNames();
        return new RacingCars(createRacingCar(names));
    }

    private List<Name> inputCarNames() {
        return InputView.requestCarName();
    }

    private List<RacingCar> createRacingCar(final List<Name> names) {
        return names.stream()
                .map(RacingCar::new)
                .collect(toList());
    }

    private TryCount getTryCount() {
        try {
            return new TryCount(InputView.requestTryCount());
        } catch (NumberFormatException | NotPositiveIntegerException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }
    }

    private void playGame() {
        OutputView.printResultMessage();

        while (canProceed()) {
            racingCars.moveAll();
            this.tryCount = tryCount.deduct();
            OutputView.printScoreBoard(racingCars);
        }

        OutputView.printWinner(racingCars);
    }

    private boolean canProceed() {
        return !tryCount.isZero();
    }
}

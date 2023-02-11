package controller;

import domain.Names;
import domain.RacingCar;
import domain.RacingCars;
import domain.TryCount;
import exception.CommaNotFoundException;
import exception.NameIsOutOfBoundException;
import exception.NotPositiveIntegerException;
import java.util.List;
import java.util.stream.Collectors;
import view.InputView;
import view.OutputView;

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
        Names names;
        try {
            names = getNames();
            return new RacingCars(createRacingCar(names));
        } catch (IllegalArgumentException | CommaNotFoundException | NameIsOutOfBoundException e) {
            System.out.println(e.getMessage());
            return createRacingCar();
        }
    }

    private Names getNames() {
        return new Names(InputView.requestCarName());
    }

    private List<RacingCar> createRacingCar(Names names) {
        return names.getNames()
                .stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    private TryCount getTryCount() {
        try {
            return new TryCount(InputView.requestTryCount());
        } catch (NotPositiveIntegerException | NumberFormatException e) {
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
        return tryCount.isOpportunity();
    }
}

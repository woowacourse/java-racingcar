package controller;

import domain.Field;
import domain.RacingCars;
import java.io.IOException;
import java.util.List;
import utils.NumberGenerator;
import view.InputView;
import view.OutputView;

public class RaceManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCars racingCars;
    private final Field field;
    private final NumberGenerator numberGenerator;
    private final int numberOfAttempts;

    public RaceManager(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingCars = repeatUntilGetValidCarNames();
        this.numberOfAttempts = repeatUntilGetValidNumberOfAttempts();
        this.field = new Field(racingCars, numberGenerator);
        this.numberGenerator = numberGenerator;
    }

    private RacingCars repeatUntilGetValidCarNames() {
        try {
            List<String> carNames = inputView.readCarNames();
            return new RacingCars(carNames);
        } catch (IOException | IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeatUntilGetValidCarNames();
        }
    }

    private int repeatUntilGetValidNumberOfAttempts() {
        try {
            return inputView.readNumberOfAttempts();
        } catch (IOException | IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeatUntilGetValidNumberOfAttempts();
        }
    }

    public void run() {
        field.race(numberOfAttempts);
        outputView.printRacingResult(field.getRacingRecord());
        outputView.printRacingWinners(field.getWinners());
    }
}

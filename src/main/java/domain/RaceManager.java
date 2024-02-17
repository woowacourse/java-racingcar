package domain;

import utils.NumberGenerator;
import view.InputView;
import view.OutputView;

import java.io.IOException;

public class RaceManager {
    private final InputView inputView;
    private final Field field;

    public RaceManager(InputView inputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.field = new Field(numberGenerator);
    }

    public void run() {
        CarGroup carGroup = repeatUntilGetValidCarNames();
        int numberOfAttempts = repeatUntilGetValidNumberOfAttempts();

        OutputView.printRaceResultHeader();
        for (int i = 0; i < numberOfAttempts; i++) {
            field.moveCars(carGroup);
            OutputView.printCarsPosition(carGroup);
        }

        OutputView.printResult(carGroup);
    }

    private CarGroup repeatUntilGetValidCarNames() {
        try {
            String[] carNames = inputView.readCarNames();
            return new CarGroup(carNames);
        } catch (IOException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatUntilGetValidCarNames();
        }
    }

    private int repeatUntilGetValidNumberOfAttempts() {
        try {
            return inputView.readNumberOfAttempts();
        } catch (IOException | IllegalArgumentException e) {
            return repeatUntilGetValidNumberOfAttempts();
        }
    }
}

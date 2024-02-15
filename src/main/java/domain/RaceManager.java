package domain;

import java.io.IOException;
import view.InputView;
import view.OutputView;

public class RaceManager {
    private final InputView inputView;
    private final CarFactory carFactory;
    private final Field field;
    private final int numberOfAttempts;

    public RaceManager(InputView inputView) {
        this.inputView = inputView;
        this.carFactory = repeatUntilGetValidCarNames();
        this.numberOfAttempts = repeatUntilGetValidNumberOfAttempts();
        this.field = new Field(carFactory);
    }

    private CarFactory repeatUntilGetValidCarNames() {
        try {
            String carNames = inputView.readCarNames();
            return new CarFactory(carNames);
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

    public void run() {
        field.race(numberOfAttempts);
        String raceResult = field.getResult();
        OutputView.printResult(raceResult);
    }
}
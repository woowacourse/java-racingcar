import domain.CarFactory;
import domain.Field;
import java.io.IOException;
import view.InputView;
import view.OutputView;

public class RaceManager {
    private final CarFactory carFactory;
    private final Field field;
    private final int numberOfAttempts;

    public RaceManager() {
        this.carFactory = repeatUntilGetValidCarNames();
        this.numberOfAttempts = repeatUntilGetValidNumberOfAttempts();
        this.field = new Field(carFactory);
    }

    private CarFactory repeatUntilGetValidCarNames() {
        try {
            String carNames = InputView.readCarNames();
            return new CarFactory(carNames);
        } catch (IOException | IllegalArgumentException e) {
            return repeatUntilGetValidCarNames();
        }
    }

    private int repeatUntilGetValidNumberOfAttempts() {
        try {
            return InputView.readNumberOfAttempts();
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
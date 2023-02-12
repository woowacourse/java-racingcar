package contoller;

import domain.Cars;
import java.util.List;
import java.util.function.Supplier;
import util.RandomGenerator;
import view.InputView;
import view.OutputView;

public class RaceController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        final Cars cars = makeCars();
        final int roundNum = repeat(inputView::readTrialNum);

        startRace(cars, roundNum);
        outputView.printWinners(cars.getWinners());
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (Exception e) {
            outputView.printErrorMessage(e);
            return repeat(inputReader);
        }
    }

    private Cars makeCars() {
        final List<String> carNames = repeat(inputView::readCarNames);
        return new Cars(carNames);
    }

    private void startRace(Cars cars, int roundNum) {
        outputView.printStart(cars);
        for (int i = 0; i < roundNum; i++) {
            cars.move(RandomGenerator.getDigit());
            outputView.printCarsStatus(cars);
        }
    }
}

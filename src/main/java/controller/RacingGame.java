package controller;

import java.util.List;
import model.Cars;
import utils.NumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingGame {
    private static final int MAX_RANDOM_NUMBER_RANGE = 9;
    public static final String SEPARATOR = ",";

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        String names = inputView.retryInputOnException(inputView::receiveNames);
        int trialCount = inputView.retryInputOnException(inputView::receiveTrialCount);

        Cars cars = Cars.from(names.split(SEPARATOR));
        race(trialCount, cars);
        outputView.printWinners(cars.getMaxLocationCarNames());
    }

    private void race(int trialCount, Cars cars) {
        outputView.printResultPrefix();
        for (int i = 0; i < trialCount; i++) {
            List<Integer> randomNumbers = createRandomNumber(cars.getCount());
            cars.moveAll(randomNumbers);
            outputView.printCurrentRace(cars);
        }
    }

    private List<Integer> createRandomNumber(int carCount) {
        return numberGenerator.generate(carCount, MAX_RANDOM_NUMBER_RANGE);
    }


}

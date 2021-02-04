package racing.controller;

import racing.domain.Cars;
import racing.view.InputView;

public class RacingController {

    public void run() {
        String carNames = InputView.getNextLine();
        Cars cars = Cars.generate(carNames);
        int tryCounts = InputView.getNextInt();
    }
}

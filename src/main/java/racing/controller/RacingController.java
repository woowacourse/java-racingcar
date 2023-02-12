package racing.controller;

import racing.domain.Cars;
import racing.ui.output.OutputView;

public class RacingController {

    private final Cars cars;

    public RacingController(Cars cars) {
        this.cars = cars;
    }

    public void start(int count) {
        OutputView.printPhrase();
        move(count);
        OutputView.printResult(cars);
    }

    private void move(int count) {
        while(count-- > 0) {
            cars.calculator();
            OutputView.printProcessing(cars);
        }
    }

}

package controller;

import domain.Cars;
import service.RacingCarService;
import view.InputView;

public class RacingCarController {

    private final InputView inputView;
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService, InputView inputView) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
    }

    public void run() {

    }

    private Cars getCars() {
        String carsName = inputView.inputCarsName();

        return null;
    }

    private int getCount() {
        String count = inputView.inputCount();

        return racingCarService.getCount(count);
    }
}

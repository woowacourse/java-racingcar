package controller;

import domain.Cars;
import service.RacingCarService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService, InputView inputView, OutputView outputView) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
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

    private void printWinners(Cars cars) {
        List<String> winners = racingCarService.findWinners(cars);
        outputView.printWinners(winners);
    }

}

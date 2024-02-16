package controller;

import domain.Cars;
import service.JudgeService;
import service.RacingCarService;
import util.Exceptions;
import view.InputView;
import view.OutputView;

import java.util.List;


public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingCarService racingCarService;
    private final JudgeService judgeService;

    public RacingCarController(RacingCarService racingCarService, InputView inputView, OutputView outputView, JudgeService judgeService) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.judgeService = judgeService;
    }

    public void run() {
        Cars cars = makeCars();
        int count = getCount();

        outputView.printMovementTitle();

        for (int i = 0; i < count; i++) {
            racingCarService.moveCars(cars);
            printMovement(cars);
        }

        printWinners(cars);
    }

    private Cars makeCars() {
        String carsName = inputView.inputCarsName();

        validateIsNull(carsName);

        return racingCarService.makeCars(carsName);
    }

    private int getCount() {
        String count = inputView.inputCount();

        validateIsNull(count);

        return racingCarService.getCount(count);
    }

    private void validateIsNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(Exceptions.NULL_EXCEPTION.getMessage());
        }
    }

    private void printMovement(Cars cars) {
        List<String> movement = racingCarService.getCurrentStatus(cars);
        outputView.printMovement(movement);
    }

    private void printWinners(Cars cars) {
        List<String> winners = judgeService.findWinners(cars);
        outputView.printWinners(winners);
    }

}

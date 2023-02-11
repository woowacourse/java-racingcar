package controller;

import java.util.List;

import service.RacingGameService;
import utils.Converter;
import view.InputView;
import view.OutputView;

public class Controller {
    private final OutputView outputView;
    private final InputView inputView;
    private final RacingGameService racingGameService;

    public Controller(OutputView outputView, InputView inputView, RacingGameService racingGameService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.racingGameService = racingGameService;
    }

    public void run() {
        createCars();
        playGame();
        printFinalResult();
    }

    private void playGame() {
        Long trial = getTrial();
        outputView.printResultMessage();
        racingGameService.move(trial);
        List<String> moveResult = racingGameService.getMoveResult();
        outputView.printMoveResult(moveResult);
    }

    private Long getTrial() {
        String trialInput = inputView.getTrial();
        try {
            return Converter.convertStringToLong(trialInput);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getTrial();
        }
    }

    private void createCars() {
        try {
            List<String> carNames = inputView.getCarNames();
            racingGameService.createCars(carNames);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            createCars();
        }
    }

    private void printFinalResult() {
        List<String> moveResult = racingGameService.getMoveResult();
        outputView.printMoveResult(moveResult);
        outputView.printWinners(racingGameService.getWinners());
    }
}

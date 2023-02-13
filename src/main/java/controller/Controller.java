package controller;

import java.util.List;

import service.RacingGameService;
import utils.Converter;
import view.InputView;
import view.OutputView;

public class Controller {
    private final RacingGameService racingGameService;

    public Controller(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        createCars();
        playGame();
        printFinalResult();
    }

    private void playGame() {
        Long trial = receiveTrialInput();
        OutputView.printResultMessage();
        for (int i = 0; i < trial; i++) {
            racingGameService.move();
            List<String> moveResult = racingGameService.retrieveMoveResults();
            OutputView.printMoveResult(moveResult);
        }
    }

    private Long receiveTrialInput() {
        String trialInput = InputView.receiveTrialInput();
        try {
            return Converter.convertStringToLong(trialInput);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return receiveTrialInput();
        }
    }

    private void createCars() {
        try {
            List<String> carNames = InputView.receiveCarNamesInput();
            racingGameService.createCars(carNames);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            createCars();
        }
    }

    private void printFinalResult() {
        List<String> moveResult = racingGameService.retrieveMoveResults();
        OutputView.printMoveResult(moveResult);
        OutputView.printWinners(racingGameService.calculateWinners());
    }
}

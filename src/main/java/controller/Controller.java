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
        setGame();
        playGame();
        printFinalResult();
    }

    private void setGame() {
        setCars();
        setTrial();
    }

    private void playGame() {
        outputView.printResultMessage();
        Long trial = racingGameService.getTrial();
        for (int i = 0; i < trial; i++) {
            racingGameService.move();
            List<String> moveResult = racingGameService.getMoveResult();
            outputView.printMoveResult(moveResult);
        }
    }

    private void setTrial() {
        String trialInput = inputView.getTrial();
        try {
            Long trial = Converter.convertStringToLong(trialInput);
            racingGameService.setTrial(trial);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setTrial();
        }
    }

    private void setCars() {
        try {
            List<String> carNames = inputView.getCarNames();
            racingGameService.setCars(carNames);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setCars();
        }
    }

    private void printFinalResult() {
        List<String> moveResult = racingGameService.getMoveResult();
        outputView.printMoveResult(moveResult);
        outputView.printWinners(racingGameService.getWinners());
    }
}

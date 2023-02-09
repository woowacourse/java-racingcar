package controller;

import service.Service;
import utils.Converter;
import view.InputView;
import view.OutputView;
import vo.Trial;

import java.util.List;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Service service = new Service();

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
        Trial trial = service.getTrial();
        for (int i = 0; i < trial.getValue(); i++) {
            service.move();
            List<String> moveResult = service.getMoveResult();
            outputView.printMoveResult(moveResult);
        }
    }

    private void setTrial() {
        String trialInput = inputView.getTrial();
        try {
            Long trial = Converter.convertStringToLong(trialInput);
            service.setTrial(trial);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setTrial();
        }
    }

    private void setCars() {
        try {
            List<String> carNames = inputView.getCarNames();
            service.setCars(carNames);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setCars();
        }
    }

    private void printFinalResult() {
        List<String> moveResult = service.getMoveResult();
        outputView.printMoveResult(moveResult);
        outputView.printWinners(service.getWinners());
    }
}

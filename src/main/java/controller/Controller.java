package controller;

import service.Service;
import view.InputView;
import view.OutputView;
import vo.Name;
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
        for (int count = 0; count < trial.getValue(); count++) {
            service.move();
            printResult();
        }
    }

    private void setTrial() {
        Trial trial = inputView.getTrial();
        try {
            service.setTrial(trial);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setTrial();
        }
    }

    private void setCars() {
        try {
            List<Name> carNames = inputView.getCarNames();
            service.setCars(carNames);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setCars();
        }
    }

    private void printFinalResult() {
        printResult();
        outputView.printWinners(service.getWinners());
    }

    private void printResult() {
        outputView.printResult(service.getResult());
    }
}

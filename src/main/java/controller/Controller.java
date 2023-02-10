package controller;

import service.Service;
import view.InputView;
import view.OutputView;
import vo.Name;
import vo.Result;
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
        Result result = service.getResult();
        outputView.printResult(result);
    }
}

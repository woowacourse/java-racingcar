package controller;

import service.Service;
import view.InputView;
import view.OutputView;
import vo.Name;
import vo.Trial;

import java.util.List;

public class Controller {
    private final OutputView outputView;
    private final InputView inputView;
    private final Service service;

    public Controller(OutputView outputView, InputView inputView, Service service) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.service = service;
    }

    public void run() {
        setGame();
        playGame();
        printFinalResult();
    }

    private void setGame() {
        setCars();
    }

    private void playGame() {
        Trial trial = getTrial();
        outputView.printResultMessage();
        for (int count = 0; count < trial.getValue(); count++) {
            service.move();
            printResult();
        }
    }

    private Trial getTrial() {
        try {
            return inputView.getTrial();
        } catch (Exception exception) {
            if (exception.getClass() == IllegalArgumentException.class) {
                outputView.printErrorMessage(exception.getMessage());
                getTrial();
            }
            throw exception;
        }
    }

    private void setCars() {
        try {
            List<Name> carNames = inputView.getCarNames();
            service.setCars(carNames);
        } catch (IllegalArgumentException exception) {
            if (exception.getClass() == IllegalArgumentException.class) {
                outputView.printErrorMessage(exception.getMessage());
                setCars();
            }
            throw exception;
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

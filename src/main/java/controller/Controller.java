package controller;

import service.Service;
import view.InputView;
import view.OutputView;
import vo.CarName;
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
        initializeCars();
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
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return getTrial();
        }
    }

    private void initializeCars() {
        try {
            List<String> carNames = inputView.getCarNames();
            service.initializeCars(CarName.of(carNames));
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            initializeCars();
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

package controller;

import java.util.List;

import service.Service;
import utils.Converter;
import view.InputView;
import view.OutputView;

public class Controller {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final Service service = new Service();

    public void run() {
        setGame();
    }

    private void setGame() {
        setCars();
        setTrial();
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
}

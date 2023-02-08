package controller;

import java.util.List;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        List<String> carNames = inputView.readCarNames();
        System.out.println(carNames);
    }
}

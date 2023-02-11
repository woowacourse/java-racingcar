package racingcar.view;

import java.util.List;
import java.util.Map;

public class ViewController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ViewRenderer viewRenderer;

    public ViewController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.viewRenderer = new ViewRenderer();
    }

    public String getCarNames() {
        outputView.printAskingInputCarNames();
        return inputView.inputCarNames();
    }

    public int getNumberOfRounds() {
        outputView.printAskingInputNumberOfRounds();
        return inputView.inputNumberOfRounds();
    }

    public void printWinners(List<String> winners) {
        outputView.printWinners(viewRenderer.renderWinners(winners));
    }

    public void startResult() {
        outputView.printResultStartingMessage();
    }

    public void printResult(Map<String, Integer> currentRoundResult) {
        outputView.printResult(viewRenderer.renderRoundResult(currentRoundResult));
    }
}

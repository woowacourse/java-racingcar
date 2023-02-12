package racingcar.view;

import racingcar.dto.CarNamesRequestDTO;
import racingcar.dto.NumberOfRoundsRequestDTO;
import racingcar.dto.RoundResultResponseDTO;
import racingcar.dto.WinnersResponseDTO;

public class ViewController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ViewRenderer viewRenderer;

    public ViewController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.viewRenderer = new ViewRenderer();
    }

    public CarNamesRequestDTO getCarNames() {
        outputView.printAskingInputCarNames();
        return inputView.inputCarNames();
    }

    public NumberOfRoundsRequestDTO getNumberOfRounds() {
        outputView.printAskingInputNumberOfRounds();
        return inputView.inputNumberOfRounds();
    }

    public void startResult() {
        outputView.printResultStartingMessage();
    }

    public void printResult(RoundResultResponseDTO currentRoundResult) {
        outputView.printResult(viewRenderer.renderRoundResult(currentRoundResult));
    }

    public void printWinners(WinnersResponseDTO winners) {
        outputView.printWinners(viewRenderer.renderWinners(winners));
    }

}

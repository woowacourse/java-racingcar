import controller.RaceController;
import java.util.List;
import view.input.InputView;
import view.output.OutputView;

public class Game {

    RaceController raceController = new RaceController();
    InputView inputView = new InputView();

    private List<String> enterCarNames() {
        OutputView.printEnterCarNames();
        return inputCarNames();
    }

    private List<String> inputCarNames() {
        try {
            return inputView.readCarNames();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            return inputCarNames();
        }
    }

    private int enterCount() {
        OutputView.printEnterCount();
        return inputCount();
    }

    private int inputCount() {
        try {
            return inputView.readCount();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            return inputCount();
        }
    }

    private void printAllResult(int count) {
        OutputView.printResultMessage();
        raceController.playGame(count);
    }

    public void play() {
        List<String> carNames = enterCarNames();
        raceController.addAllParticipants(carNames);
        int count = enterCount();
        printAllResult(count);
    }
}

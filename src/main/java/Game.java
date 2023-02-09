import controller.RaceController;
import domain.Car;
import java.util.List;
import view.input.InputView;
import view.output.OutputView;

public class Game {

    private RaceController raceController = new RaceController();
    private InputView inputView = new InputView();

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

    private void printWinners(List<Car> winners) {
        OutputView.printWinners(winners);
    }

    public void play() {
        List<String> carNames = enterCarNames();
        raceController.addAllParticipants(carNames);
        int count = enterCount();
        printAllResult(count);
        printWinners(raceController.getWinners());
    }
}

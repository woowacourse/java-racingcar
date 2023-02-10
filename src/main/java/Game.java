import controller.RaceController;
import domain.Car;
import java.util.List;
import view.input.InputView;
import view.output.OutputView;

public class Game {

    private RaceController raceController = new RaceController();
    private InputView inputView = new InputView();
    
    public void play() {
        List<String> carNames = inputCarNames();
        raceController.addAllParticipants(carNames);
        int count = inputCount();
        printAllResult(count);
        printWinners(raceController.getWinners());
    }

    private List<String> inputCarNames() {
        try {
            return inputView.readCarNames();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            return inputCarNames();
        }
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
}

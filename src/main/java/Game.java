import controller.RaceController;
import domain.Car;
import java.util.List;
import util.NumberGenerator;
import view.input.InputView;
import view.output.OutputView;

public class Game {

    private final RaceController raceController;

    public Game(RaceController raceController) {
        this.raceController = raceController;
    }

    public void ready(InputView inputView) {
        raceController.getParticipants(inputView);
        raceController.getCount(inputView);
    }

    public void playGame(NumberGenerator numberGenerator) {
        while (!raceController.isFinished()) {
            raceOneRound(numberGenerator);
        }
        raceController.printRoundResult();
    }

    public void raceOneRound(NumberGenerator numberGenerator) {
        List<Car> cars = raceController.showStatus();
        if (!raceController.isFinished()) {
            cars.forEach((car) -> raceController.driveOrNot(car, numberGenerator));
            raceController.roundFinished();
        }
        raceController.printRoundResult();
    }

    public void showResult() {
        OutputView.printResultMessage();
        OutputView.printWinners(raceController.getWinners());
    }
}

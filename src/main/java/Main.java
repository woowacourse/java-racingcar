import controller.RacingCarController;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (InputView inputView = new InputView(); OutputView outputView = new OutputView()) {
            List<String> carsName = inputView.inputCarsName();
            int trialCount = inputView.inputTrialCount();

            RacingCarController racingCarController = new RacingCarController(carsName, trialCount);
            racingCarController.run();

            outputView.printResultComment();
            outputView.printAllRacingResult(racingCarController.getRacingCars(), trialCount);
            outputView.printWinner(racingCarController.findWinners());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

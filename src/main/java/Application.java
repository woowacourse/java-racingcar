import controller.CarRacingController;
import domain.Judge;
import service.RacingCarService;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarService racingCarService = new RacingCarService();
        Judge judge = new Judge();

        CarRacingController carRacingController = new CarRacingController(racingCarService, inputView, outputView, judge);

        carRacingController.run();
    }

}

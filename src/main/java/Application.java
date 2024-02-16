import controller.RacingCarController;
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

        RacingCarController racingCarController = new RacingCarController(racingCarService, inputView, outputView, judge);

        racingCarController.run();
    }

}

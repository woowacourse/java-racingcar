import controller.RacingCarController;
import service.JudgeService;
import service.RacingCarService;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarService racingCarService = new RacingCarService();
        JudgeService judgeService = new JudgeService();

        RacingCarController racingCarController = new RacingCarController(racingCarService, inputView, outputView, judgeService);

        racingCarController.run();
    }

}

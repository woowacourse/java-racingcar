import controller.Controller;
import service.RacingGameService;
import utils.numberGenerator.NumberGenerator;
import utils.numberGenerator.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        RacingGameService racingGameService = new RacingGameService(randomNumberGenerator);

        Controller controller = new Controller(racingGameService);
        controller.run();
    }
}

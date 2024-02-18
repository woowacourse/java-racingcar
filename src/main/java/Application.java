import controller.RacingCarController;
import domain.RacingCarMapper;
import domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(new RandomNumberGenerator(), new RacingCarMapper());
        racingCarController.start();
    }
}

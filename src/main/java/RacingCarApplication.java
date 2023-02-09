import controller.RacingCarController;
import java.io.IOException;

public class RacingCarApplication {

    public static void main(String[] args) throws IOException {
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.run();
    }
}

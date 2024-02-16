import controller.RacingCarController;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        RacingCarController controller = new RacingCarController();
        controller.run();
    }
}

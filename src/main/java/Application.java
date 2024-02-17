import controller.RacingCarController;
import java.io.IOException;

public class Application {

    public static void main(final String[] args) throws IOException {
        RacingCarController controller = new RacingCarController();
        controller.run();
    }
}

import controller.RacingCarController;
import java.io.IOException;
import view.InputView;
import view.OutputView;

public class Main {
  public static void main(String[] args) throws IOException {
    new RacingCarController(new InputView(), new OutputView()).run();
  }
}

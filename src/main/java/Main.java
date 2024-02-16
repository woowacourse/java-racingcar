import controller.RacingCarController;
import java.io.IOException;
import view.InputView;
import view.OutputView;

public class Main {
  public static void main(String[] args) throws IOException {
    try (InputView inputView = new InputView()) {
      new RacingCarController(inputView, new OutputView()).run();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

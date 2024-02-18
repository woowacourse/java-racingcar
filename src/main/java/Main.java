import controller.RacingCarController;
import java.io.IOException;
import view.InputView;
import view.OutputView;

public class Main {
  public static void main(String[] args) {
    try (InputView inputView = new InputView(); OutputView outputView = new OutputView()) {
      new RacingCarController(inputView, outputView).run();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

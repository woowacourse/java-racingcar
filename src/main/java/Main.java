import controller.RacingCarController;
import view.InputView;
import view.OutputView;

public class Main {
  public static void main(String[] args) throws Exception {
    try (InputView inputView = new InputView()) {
      new RacingCarController(inputView, new OutputView()).run();
    }
  }
}

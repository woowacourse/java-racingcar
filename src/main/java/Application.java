import controller.GameController;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new OutputView());
        gameController.run();
    }
}

import controller.MainController;
import model.RandomCarMoveManager;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(InputView.getInstance(), OutputView.getInstance(),
                new RandomCarMoveManager());
        mainController.play();
    }
}
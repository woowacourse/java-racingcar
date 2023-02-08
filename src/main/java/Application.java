import controller.GameController;
<<<<<<< HEAD

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
=======
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new OutputView());
>>>>>>> 984262c (feat: 자동차 이름 입력)
        gameController.run();
    }
}

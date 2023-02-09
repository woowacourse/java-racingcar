import controller.InputController;
import domain.CarRepositoryImpl;


public class Main {

    public static void main(String[] args) {
        InputController inputController = new InputController(new CarRepositoryImpl());
        inputController.startProgram();
    }
}

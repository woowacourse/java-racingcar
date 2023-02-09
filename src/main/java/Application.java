import controller.Controller;
import domain.RandomNumberPicker;
import view.ConsoleOutput;
import view.InputView;
import view.OutputView;
import view.UserInput;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new RandomNumberPicker(),
                new UserInput(),
                new OutputView(new ConsoleOutput()),
                new InputView(new ConsoleOutput()));
        controller.raceTracks();
    }
}

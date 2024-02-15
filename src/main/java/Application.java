import controller.RacingGameController;
import view.ConsolePrinter;
import view.ConsoleReader;
import view.InputView;
import view.OutputView;
import view.Printer;
import view.Reader;

public class Application {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();

        InputView inputView = InputView.of(reader, printer);
        OutputView outputView = new OutputView(printer);

        RacingGameController racingGameController = new RacingGameController(inputView, outputView);
        racingGameController.run();
    }
}

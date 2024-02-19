import controller.RacingGameController;
import view.Printer.Printer;
import view.InputView;
import view.OutputView;
import view.Reader.Reader;

public class Application {

    public static void main(String[] args) {
        Reader reader = new Reader();
        Printer printer = new Printer();

        InputView inputView = InputView.of(reader, printer);
        OutputView outputView = new OutputView(printer);

        RacingGameController racingGameController = new RacingGameController(inputView, outputView);
        racingGameController.run();
    }
}

import controller.RacingGameController;
import domain.MovementGenerator;
import domain.NumberGenerator;
import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import view.Printer.ConsolePrinter;
import view.Reader.ConsoleReader;
import view.InputView;
import view.OutputView;
import view.Printer.Printer;
import view.Reader.Reader;

public class Application {

    public static void main(String[] args) {
        Reader reader = new ConsoleReader();
        Printer printer = new ConsolePrinter();

        InputView inputView = InputView.of(reader, printer);
        OutputView outputView = new OutputView(printer);

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MovementGenerator movementGenerator = new RandomMovementGenerator(numberGenerator);

        RacingGameController racingGameController = new RacingGameController(inputView, outputView, movementGenerator);
        racingGameController.run();
    }
}

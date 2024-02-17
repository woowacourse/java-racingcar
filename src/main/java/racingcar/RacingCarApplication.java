package racingcar;

import racingcar.random.NumberGenerator;
import racingcar.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.reader.ConsoleReader;
import racingcar.view.reader.Reader;

public class RacingCarApplication {
    public static void main(String[] args) {

        Reader reader = new ConsoleReader(System.in);
        InputView inputView = new InputView(reader);
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        CarController controller = new CarController(inputView, outputView, numberGenerator);
        controller.run();

    }
}

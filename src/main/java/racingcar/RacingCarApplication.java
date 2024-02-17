package racingcar;

import racingcar.random.NumberGenerator;
import racingcar.random.RacingCarNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.view.reader.ConsoleReader;
import racingcar.view.reader.Reader;

public class RacingCarApplication {

    public static void main(String[] args) {

        Reader reader = new ConsoleReader(System.in);
        InputView inputView = new InputView(reader);
        OutputView outputView = new OutputView();
        NumberGenerator numberGenerator = new RacingCarNumberGenerator();
        RacingGame controller = new RacingGame(inputView, outputView, numberGenerator);
        controller.play();

    }
}

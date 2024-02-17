package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

import racingcar.model.Cars;
import racingcar.model.TryCount;

public class InputView {
    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));
    
    public static Cars inputRacingCars() {
        return requestInput(
                () -> OutputView.printRequestCarNamesMessage(),
                input -> new Cars(input));
    }

    public static TryCount inputTryCount() {
        return requestInput(
                () -> OutputView.printRequestTryCountMessage(),
                input -> new TryCount(input));
    }

    private static <T> T requestInput(Runnable requestMessage, Function<String,T> creator) {
        requestMessage.run();
        try {
            return creator.apply(CONSOLE.readLine());
        } catch(IOException e) {
            throw new IllegalArgumentException();
        }
    }
}

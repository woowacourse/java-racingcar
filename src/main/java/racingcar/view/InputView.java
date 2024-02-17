package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import racingcar.model.Cars;
import racingcar.model.TryCount;

// TODO: 메서드의 구조가 동일함. 분리하는 방법 고민 필요
public class InputView {
    private static final BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    public static Cars inputRacingCars() {
        OutputView.printRequestCarNamesMessage();
        try {
            var carNames = CONSOLE.readLine();
            return new Cars(carNames);
        } catch(IOException e) {
            throw new IllegalArgumentException();
        }
    }

    public static TryCount inputTryCount() {
        OutputView.printRequestTryCountMessage();
        try {
            var tryCount = CONSOLE.readLine();
            return new TryCount(tryCount);
        } catch(IOException e) {
            throw new IllegalArgumentException();
        }
    }
}

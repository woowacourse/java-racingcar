import domain.Cars;
import domain.TryCount;
import io.InputView;

import java.util.Arrays;

public class CarRacing {
    private static InputView inputView = new InputView();
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Cars cars = createCars(inputView.readCarNames());
        TryCount tryCount = createTryCount(inputView.readTryAmount());
    }

    public static Cars createCars(String carNames) {
        return new Cars(Arrays.asList(carNames.split(",")));
    }

    public static TryCount createTryCount(int amount) {
        return new TryCount(amount);
    }
}

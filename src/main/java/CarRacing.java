import domain.Cars;
import io.InputView;

import java.util.Arrays;

public class CarRacing {
    private static InputView inputView = new InputView();
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        Cars cars = createCars(inputView.read());
    }

    public static Cars createCars(String carNames) {
        return new Cars(Arrays.asList(carNames.split(",")));
    }
}

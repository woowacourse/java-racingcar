package racinggame.domain;

import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    public static final int NUMBER_BOUND = 10;

    /* 인스턴스를 사용하지 않으므로 추가 */
    private RacingGame() {
    }

    public static int generateRandom() {
        return new Random().nextInt(NUMBER_BOUND);
    }

    public static void play(Input input, Output output) {
        List<String> names = input.splitInputByComma();
        List<Car> cars = new ArrayList<>();
        int repeat = input.parseRepeatToInt();

        output.initCarStatus(names);
        names.stream().forEach(x -> cars.add(new Car(x)));
        OutputView.printResultFormat();
        moveCars(output, cars, repeat);
        output.makeWinnerNames(cars);
    }

    private static void moveCars(Output output, List<Car> cars, int repeat) {
        for (int i = 0; i < repeat; i++) {
            cars.stream().forEach(car -> {
                car.move(generateRandom());
                car.passingLog(output);
            });
            output.printLog();
        }
    }
}

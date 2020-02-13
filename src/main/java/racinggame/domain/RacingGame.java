package racinggame.domain;

import racinggame.controller.Input;
import racinggame.controller.Output;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private RacingGame() {
    }

    public static int generateRandom() {
        return new Random().nextInt(10);
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

package racingGame.domain;

import racingGame.controller.Input;
import racingGame.controller.Output;
import racingGame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {


    public static int generateRandom() {
        int random = new Random().nextInt(10);
        return random;
    }

    public static void play(Input input, Output output) {
        List<String> names = input.splitInputByComma();
        List<Car> cars = new ArrayList<>();
        int repeat = input.parseRepeatToInt();

        output.initCarStatus(names);
        names.stream().forEach((x)->cars.add(new Car(x)));
        OutputView.printResultFormat();
        for (int i = 0; i < repeat; i++) {
            cars.stream().forEach((x) -> {
                x.move(generateRandom());
                x.passingLog(output);
            });
            output.printLog();
        }
        output.makeWinnerNames(cars);
    }
}

package racingGame.domain;

import racingGame.controller.Input;
import racingGame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {


    public static int generateRandom() {
        int random = new Random().nextInt(10);
        return random;
    }

    public static List<String> play(Input input) {
        List<String> names = input.splitInputByComma();
        int repeat = input.parseRepeatToInt();

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        OutputView.printResultFormat();
        for (int i = 0; i < repeat; i++) {
            cars.stream().forEach((x) -> {
                int random = generateRandom();
                x.move(random);
                x.passingLog();
            });
            OutputView.printLine();
        }
        List<String> winners = new ArrayList<>();
        cars.stream().forEach((x) -> {
            x.addWinnerName(winners);
        });
        return winners;
    }
}

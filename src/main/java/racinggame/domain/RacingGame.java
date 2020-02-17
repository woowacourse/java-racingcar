package racinggame.domain;

import racinggame.view.OutputView;

import java.util.List;
import java.util.Random;

public class RacingGame {
    public static final int NUMBER_BOUND = 10;

    /* 인스턴스를 사용하지 않으므로 추가 */
    private RacingGame() {
    }

    public static int generateRandom() {
        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        return rand.nextInt(NUMBER_BOUND);
    }

    public static void play(Input input) {
        List<String> names = input.splitInputByComma();
        int repeat = input.parseRepeatToInt();
        Cars cars = new Cars(names);
        OutputView.printResultFormat();
        for (int i = 0; i < repeat; i++) {
            cars.moveAllCars();
        }
        Winners winners = cars.makeWinners();
        OutputView.printWinnersLog(winners);
    }
}

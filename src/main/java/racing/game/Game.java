package racing.game;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int ROUND_MIN_LIMIT = 1;
    private static final int CAR_COUNT_MIN_LIMIT = 2;

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        List<Car> cars;
        int roundNum;

        while (((cars = convertNamesToCars(InputView.getCarNames())).size()) < CAR_COUNT_MIN_LIMIT) ;
        while ((roundNum = checkRoundNum(InputView.getRoundNumber())) < ROUND_MIN_LIMIT) ;
        System.out.print("\n실행 결과");
        for (int i = 0; i < roundNum; i++) {
            Rounds.doRound(cars);
            OutputView.showCarsPosition(cars);
        }
        OutputView.showChampion(Rounds.calculateChampions(cars));
    }

    static List<Car> convertNamesToCars(String names) {
        List<Car> cars = new ArrayList<>();
        try {
            for (String name : splitNamesWithComma(names)) {
                Car car = new Car(name, cars);
                cars.add(car);
            }
        } catch (Exception e) {
            OutputView.showNamesError();
            cars.clear();
        }
        return cars;
    }

    static String[] splitNamesWithComma(String names) throws Exception {
        String[] nameSplitted = names.split(",");
        if (nameSplitted.length < CAR_COUNT_MIN_LIMIT)
            throw new Exception();

        return nameSplitted;
    }

    static int checkRoundNum(String roundInput) {
        int round = 0;
        try {
            round = Integer.parseInt(roundInput);
            if (round < ROUND_MIN_LIMIT)
                throw new Exception();
        } catch (Exception e) {
            OutputView.showRoundNumError();
        }
        return round;
    }
}

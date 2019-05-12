package racing.game;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        List<Car> cars = convertNamesToCarList(InputView.getCarNames());
        int roundNum = InputView.getRoundNumber();

        System.out.print("\n실행 결과");
        for (int i = 0; i < roundNum; i++) {
            Rounds.doRound(cars);
            OutputView.showCarsPosition(cars);
        }
        OutputView.showChampion(Rounds.calculateChampions(cars));
    }

    public static List<Car> convertNamesToCarList(String names) {
        List<Car> cars = new ArrayList<>();
        try {
            for (String name : names.split(",")) {
                Car car = new Car(name, cars);
            }
        } catch (Exception e) {
            OutputView.showNamesError();
        }
        return cars;
    }
}

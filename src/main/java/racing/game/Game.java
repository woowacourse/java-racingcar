package racing.game;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        play();
    }

    public static void play() {
        List<Car> cars = InputView.getCars();
        int roundNum = InputView.getRoundNumber();

        System.out.print("\n실행 결과");
        for (int i = 0; i < roundNum; i++) {
            Rounds.doRound(cars);
            OutputView.showCarsPosition(cars);
        }
        OutputView.showChampion(Rounds.calculateChampions(cars));
    }
}

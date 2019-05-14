package racing.game;

import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class GameApplication {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        List<Car> cars = getCars();
        int roundNum = getRoundNum();

        OutputView.showRace();
        for (int i = 0; i < roundNum; i++) {
            OutputView.showCarsPosition(Rounds.doRound(cars).toString());
        }
        Winner winner = new Winner();
        winner.calculateChampions(cars);
        OutputView.showChampion(winner.toString());
    }

    private static int getRoundNum() {
        int roundNum;
        while ((roundNum = Rounds.checkRoundNum(InputView.getRoundNumber())) < Rounds.ROUND_MIN_LIMIT) {
            OutputView.showRoundNumError();
        }
        return roundNum;
    }

    private static List<Car> getCars() {
        List<Car> cars;
        while (((cars = Rounds.convertNamesToCars(InputView.getCarNames())).size()) < Rounds.CAR_COUNT_MIN_LIMIT) {
            OutputView.showNamesError();
        }
        return cars;
    }
}

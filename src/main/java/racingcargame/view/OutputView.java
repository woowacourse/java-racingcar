package racingcargame.view;

import racingcargame.model.Round;
import racingcargame.model.Winner;

import java.util.List;

public class OutputView {
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다";

    public static void printRound(List<Round> rounds) {
        for (Round round : rounds){
            System.out.println(round);
        }
    }

    public static void printGameResult(Winner winner) {
        System.out.println(winner + WINNER_MESSAGE);
    }
}

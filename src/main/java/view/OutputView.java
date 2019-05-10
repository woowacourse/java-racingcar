package view;

import domain.Const;

public class OutputView {
    public static void outputGameResultTile() {
        System.out.println(Const.OUTPUT_GAME_RESULT);
    }

    public static void outputGameResult(String gameResult) {
        System.out.println(gameResult);
    }

    public static void outputWinners(String winners) {
        System.out.println(winners + Const.OUTPUT_WINNER);
    }
}

package racingcar;

import java.util.ArrayList;
import java.util.List;

class Output {
    static String GAME_START;
    private static String FINAL_WINNER;

    static {
        GAME_START = "\n실행 결과";
        FINAL_WINNER = "가 최종 우승했습니다.";
    }

    static void print(String message) {
        System.out.println(message);
    }

    static void finalWinner(RacingGameResult result) {
        List<String> winList = new ArrayList<>();

        for (Car car : result.getWinners()) {
            winList.add(car.getName());
        }

        String str = String.join(", ", winList) + FINAL_WINNER;
        print(str);
    }
}

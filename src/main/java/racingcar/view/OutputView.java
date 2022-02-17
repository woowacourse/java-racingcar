package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String TRIAL_RESULT = "실행 결과:";
    private static final String WINNER_ANNOUNCEMENT = "가 최종 우승했습니다.";
    public static void printGameStartMessage(){
        System.out.println(TRIAL_RESULT);
    }

    public static void printCurrentRaceState(List<String> currentRaceState){
        for (String oneCarState : currentRaceState) {
            System.out.println(oneCarState);
        }
    }

    public static void printWinners(List<String> winnerNames){
        System.out.println(String.join(WINNER_NAME_DELIMITER, winnerNames) + WINNER_ANNOUNCEMENT);
    }
}

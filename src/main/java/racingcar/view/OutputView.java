package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String NAME_POSITION_CONNECTOR = " : ";
    private static final String POSITION_MARKER = "-";
    private static final String TRIAL_RESULT = "실행 결과:";
    private static final String WINNER_ANNOUNCEMENT = "가 최종 우승했습니다.";
    public static void printGameStartMessage(){
        System.out.println(TRIAL_RESULT);
    }

    public static void printCurrentRaceState(Map<String, Integer> carNamesAndPositions){
        carNamesAndPositions.keySet()
            .stream()
            .forEach(s -> raceStateFormat(s, carNamesAndPositions.get(s)));
        System.out.println();
    }
    private static void raceStateFormat(String name, int position) {
        System.out.println(name + NAME_POSITION_CONNECTOR + visualizePosition(position));
    }

    private static String visualizePosition(int position) {
        return POSITION_MARKER.repeat(position);
    }


    public static void printWinners(List<String> winnerNames){
        System.out.println(String.join(WINNER_NAME_DELIMITER, winnerNames) + WINNER_ANNOUNCEMENT);
    }
}

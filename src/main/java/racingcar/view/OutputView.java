package racingcar.view;

import java.util.List;
import java.util.Set;
import racingcar.model.RoundResult;

public class OutputView {

    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String WINNER_RESULT_DELIMITER = ",";
    private static final String ROAD = "-";
    private static final String WINNER_RESULT_MESSAGE = "(이)가 최종 우승하였습니다.";

    public void announceRacingStart() {
        System.out.println(EXECUTE_RESULT);
    }

    public void recordScore(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            printEachRoundResult(roundResult);
            System.out.println();
        }
    }

    public void recordRacingWinners(List<String> winners) {
        System.out.println(String.join(WINNER_RESULT_DELIMITER, winners) + WINNER_RESULT_MESSAGE);
    }

    private void printEachRoundResult(RoundResult roundResult) {

        Set<String> participantsNames = roundResult.getParticipantsNames();
        for (String participantsName : participantsNames) {

            System.out.println(participantsName + " : " + ROAD.repeat(roundResult.findLocationBy(participantsName)));
        }
    }
}

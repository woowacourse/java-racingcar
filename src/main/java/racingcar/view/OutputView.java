package racingcar.view;

import racingcar.domain.result.Result;
import racingcar.view.message.Message;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printCarNameInputGuide() {
        print(Message.CAR_NAME_INPUT_GUIDE.getMessage());
    }

    public void printGameRoundGuide() {
        print(Message.GAME_ROUND_INPUT_GUIDE.getMessage());
    }

    public void printResultGuide() {
        print(Message.GAME_RESULT_GUIDE.getMessage());
    }

    public void printResult(Result result) {
        List<Map<String, Integer>> results = result.getResults();
        for (Map<String, Integer> roundResult : results) {
            printEachResult(roundResult);
            print(Message.EMPTY_MESSAGE.getMessage());
        }
    }

    private void printEachResult(Map<String, Integer> roundResult) {
        String positionMarker = Message.POSITION_MARKER.getMessage();
        for (String carName : roundResult.keySet()) {
            String position = makePosition(roundResult, positionMarker, carName);
            print(makeResultMessage(carName, position));
        }
    }

    private String makePosition(Map<String, Integer> roundResult, String positionMarker, String key) {
        return positionMarker.repeat(roundResult.get(key));
    }

    private String makeResultMessage(String key, String position) {
        return String.format(Message.RESULT_DELIMITER.getMessage(), key, position);
    }

    public void printWinner(Result results) {
        String delimiter = Message.WINNER_DELIMITER.getMessage();
        print(makeWinnerMessage(results, delimiter));
    }

    private String makeWinnerMessage(Result results, String delimiter) {
        return String.format(Message.WINNER_GUIDE.getMessage(), makeWinner(results, delimiter));
    }

    private String makeWinner(Result results, String delimiter) {
        return String.join(delimiter, results.findWinners());
    }

    private void print(String message) {
        System.out.println(message);
    }
}

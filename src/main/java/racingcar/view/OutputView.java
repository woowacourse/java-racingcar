package racingcar.view;

import java.util.stream.Collectors;
import racingcar.domain.vo.RoundResult;
import racingcar.domain.dto.ResponseRoundResultDto;
import racingcar.domain.dto.ResponseWinnersDto;

public class OutputView {

    private static final String RACE_RESULT_MESSAGE = "실행 결과";
    private static final String POSITION_BAR = "-";
    private static final String RESULT_DELIMITER = " : ";

    private static final String WINNERS_DELIMITER = ",";
    private static final String WINNER_MESSAGE_FORM = "%s가 최종 우승했습니다.";

    public void printRaceResult(ResponseRoundResultDto dto) {
        System.out.println(RACE_RESULT_MESSAGE);
        for (RoundResult result : dto.getResults()) {
            printRoundResult(result);
        }
    }

    private void printRoundResult(RoundResult result) {
        for (String name : result.getNames()) {
            printNameAndPositionBar(name, result.getPosition(name));
        }
        System.out.println();
    }

    private void printNameAndPositionBar(String name, Integer position) {
        String builder = name
                + RESULT_DELIMITER
                + POSITION_BAR.repeat(Math.max(0, position));
        System.out.println(builder);
    }

    public void printWinners(ResponseWinnersDto dto) {
        String winnersString = dto.getWinners().stream()
                .map(car -> car.getName().get())
                .collect(Collectors.joining(WINNERS_DELIMITER));
        System.out.printf(WINNER_MESSAGE_FORM, winnersString);
    }
}

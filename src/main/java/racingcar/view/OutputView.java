package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_INFORMATION_DELIMITER = " : ";
    private static final String DISTANCE_COMMAND = "-";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_NAME_DELIMITER = ", ";

    public void printNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printCountInput() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<Car> roundResult) {
        roundResult.forEach(car -> System.out.println(car.getName().getValue()
                + CAR_INFORMATION_DELIMITER
                + DISTANCE_COMMAND.repeat(car.getDistance().getValue())));
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        System.out.println(winnerNames.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER))
                + WINNER_MESSAGE);
    }
}

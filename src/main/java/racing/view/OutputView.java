package racing.view;

import racing.model.Car;
import racing.model.Position;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String INPUT_CAR_NAMES_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세(이름은 쉼표(,)를 기준으로 구분";
    private static final String INPUT_TRIAL_TIME_GUIDE_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_HEADING = "실행 결과";
    private static final String WINNER_SUB_MESSAGE = "가 최종 우승했습니다.";
    public static final String DELIMITER = ", ";

    public static void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_GUIDE_MESSAGE);
    }

    public static void printInputTrialTimeMessage() {
        System.out.println(INPUT_TRIAL_TIME_GUIDE_MESSAGE);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(RESULT_HEADING);
    }

    public static void printCurrentDashResult(String name, Position position) {
        StringBuilder result = new StringBuilder();
        result.append(name);
        result.append(COLON);
        for (int index = 0; index < position.getPosition(); index++){
            result.append(DASH);
        }
        System.out.println(result);
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnersName = winners.stream()
                                    .map(Car::getName)
                                    .collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        result.append(String.join(DELIMITER, winnersName))
                .append(WINNER_SUB_MESSAGE);
        System.out.println(result);
    }
}

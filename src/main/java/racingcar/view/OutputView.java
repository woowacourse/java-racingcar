package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Position;
import racingcar.domain.Racer;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_TRIALS = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_TITLE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String MARKER_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MARKER_OF_POSITION = "-";
    private static final String DELIMITER_COMMA = ",";

    private OutputView() {
    }

    public static void enterRacerNames() {
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }

    public static void enterTrials() {
        System.out.println(ENTER_TRIALS);
    }

    public static void printCurrentResult(Car car) {
        Racer racer = car.getRacer();
        Position position = car.getPosition();
        StringBuilder currentResult = new StringBuilder(racer.getName());
        currentResult.append(MARKER_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < position.getPosition(); i++) {
            currentResult.append(MARKER_OF_POSITION);
        }
        System.out.println(currentResult.toString());
    }

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void printWinners(List<Car> winnerCars) {
        String winner = winnerCars.stream()
                .map(Car::getRacer)
                .map(Racer::getName)
                .collect(Collectors.joining(DELIMITER_COMMA));
        System.out.println(winner + WINNER_MESSAGE);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}

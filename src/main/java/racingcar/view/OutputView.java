package racingcar.view;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_TRIALS = "시도할 횟수는 몇 회인가요?";
    private static final String RESULT_TITLE = "실행 결과";
    private static final String WINNER_TITLE = "최종 우승자: ";
    private static final String MARKER_BETWEEN_NAME_AND_POSITION = " : ";
    private static final String MARKER_OF_POSITION = "-";
    private static final String NEW_LINE = "\n";

    private OutputView() {
    }

    public static void getCarNames() {
        System.out.println(ENTER_CAR_NAMES);
    }

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }

    public static void getTrials() {
        System.out.println(ENTER_TRIALS);
    }

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void showResult(List<Car> winners) {
        printWinnerTitle();
        printWinners(winners);
    }

    public static void printWinnerTitle() {
        System.out.print(WINNER_TITLE);
    }

    public static void printWinners(List<Car> winners) {
        System.out.println(winners.stream().map(Car::getName).collect(Collectors.joining(",")));
    }

    public static void printCurrentResult(HashMap<String, Integer> currentInfoOfCars) {
        StringBuilder currentPosition = new StringBuilder();
        currentInfoOfCars.forEach((name, position) -> {
            currentPosition.append(makeCurrentStatusOfEachCar(name, position));
            currentPosition.append(NEW_LINE);
        });
        System.out.println(currentPosition.toString());
    }

    private static String makeCurrentStatusOfEachCar(String name, int position) {
        StringBuilder current = new StringBuilder(name);
        current.append(MARKER_BETWEEN_NAME_AND_POSITION);
        for (int i = 0; i < position; i++) {
            current.append(MARKER_OF_POSITION);
        }
        return current.toString();
    }
}

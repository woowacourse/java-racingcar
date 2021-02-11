package racingcar.view;

import racingcar.domain.Car.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    public static final String ASK_CAR_NAMES =
            "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).은 쉼표(,)를 기준으로 구분).";
    public static final String ASK_TURNS =
            "시도할 회수는 몇회인가요?";
    public static final String RESULT_PREFIX =
            "실행 결과";
    public static final String PRINT_WINNERS =
            "%s가 최종 우승했습니다.";

    public static void printAskCarNames() {
        System.out.println(ASK_CAR_NAMES);
    }

    public static void printAskTurns() {
        System.out.println(ASK_TURNS);
    }

    public static void printResultPrefix() {
        System.out.println(System.lineSeparator() + RESULT_PREFIX);
    }

    public static void printCarsStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(getCarStatus(car)));
        System.out.println();
    }

    private static String getCarStatus(Car car) {
        return car.getName() + " : " + getPositionToString(car.getPosition());
    }

    private static String getPositionToString(int position) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, position)
                .forEach(i -> sb.append("-"));
        return sb.toString();
    }

    public static void printWinners(List<Car> winners) {
        String winnersName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.printf((PRINT_WINNERS) + "%n", winnersName);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
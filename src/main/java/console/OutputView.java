package console;

import domain.Car;
import domain.Cars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DELIMITER = ", ";

    public static void requestOfCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void requestOfTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printWinner(Cars cars) {

        List<String> winnerCarName = cars.getWinner()
                                         .stream()
                                         .map(Car::getName)
                                         .collect(Collectors.toList());

        System.out.print(String.join(DELIMITER, winnerCarName));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printCurrentStatus(Cars cars) {
        final Map<String, Integer> carCurrentStatus = cars.getCurrentStatus();

        StringBuilder stringBuilder = new StringBuilder();

        for (final String carName : carCurrentStatus.keySet()) {
            stringBuilder.append(carName)
                         .append(" : ")
                         .append("-".repeat(carCurrentStatus.get(carName)))
                         .append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

}

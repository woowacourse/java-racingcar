package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Position;

public class OutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_INFORMATION_DELIMITER = " : ";
    private static final String POSITION_COMMAND = "-";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printNameInput() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public static void printCountInput() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> carsStatus) {
        for (Car car : carsStatus) {
            Position position = car.getPosition();
            printCarResult(car.getName(), position.getPosition());
        }
        System.out.println("");
    }

    private static void printCarResult(String carName, int position) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(carName).append(CAR_INFORMATION_DELIMITER);
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_COMMAND);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printWinners(List<String> winnerNames) {
        StringBuilder stringBuilder = new StringBuilder("\n");
        String str = String.join(", ", winnerNames);
        stringBuilder.append(str).append(WINNER_MESSAGE);
        System.out.println(stringBuilder.toString());
    }
}

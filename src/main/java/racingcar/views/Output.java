package racingcar.views;

import racingcar.models.Car;
import racingcar.models.CarDto;

import java.util.List;

public class Output {

    private static final String TURN_RESULT = "\n실행결과";
    private static final String FINAL_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String CAR_POSITION = "-";
    private static final String NAME_POSITION_SPLITTER = " : ";
    private final static String CAR_NAME_DISTRIBUTOR = ", ";

    public static void printResultMessage() {
        System.out.println(TURN_RESULT);
    }

    public static void printTurnResult(final List<CarDto> cars) {
        cars.forEach(car ->
                System.out.println(car.getName() + NAME_POSITION_SPLITTER + CAR_POSITION.repeat(car.getPosition())));

        System.out.print(System.lineSeparator());
    }

    public static void printWinners(final List<String> winners) {
        System.out.println(String.join(CAR_NAME_DISTRIBUTOR, winners) + FINAL_WINNER_MESSAGE);
    }
}

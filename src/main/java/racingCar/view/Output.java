package racingCar.view;

import java.util.List;
import racingCar.model.CarDTO;

public class Output {
    private static final String RESULT_FRONT_MESSAGE = System.lineSeparator() + "실행 결과";
    private static final String WINNER_REGEX = ", ";
    private static final String WINNER_RESULT_LAST_MESSAGE = "가 최종 우승했습니다.";
    private static final String ROUND_REGEX = " : ";
    private static final String POSITION_SIGNATURE = "-";

    public static void printStartMessage() {
        System.out.println(RESULT_FRONT_MESSAGE);
    }

    public static void printRoundResult(List<CarDTO> cars) {
        for (CarDTO car : cars) {
            System.out.println(
                    car.name + ROUND_REGEX + POSITION_SIGNATURE.repeat(car.position));
        }
        System.out.println();
    }

    public static void printWinner(List<CarDTO> winnerCars) {
        StringBuilder Result = new StringBuilder();
        for (CarDTO winnerCar : winnerCars) {
            Result.append(winnerCar.name).append(WINNER_REGEX);
        }
        System.out.println(Result.substring(0, Result.length() - 2) + WINNER_RESULT_LAST_MESSAGE);
    }
}
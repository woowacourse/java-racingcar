package racingCar.view;

import racingCar.domain.dto.CarDto;
import racingCar.domain.dto.CarsDto;

public class OutputView {
    private static final String RESULT_FRONT_MESSAGE = System.lineSeparator() + "실행 결과";
    private static final String WINNER_REGEX = ", ";
    private static final String WINNER_RESULT_LAST_MESSAGE = "가 최종 우승했습니다.";
    private static final String ROUND_REGEX = " : ";
    private static final String POSITION_SIGNATURE = "-";

    public static void printStartMessage() {
        System.out.println(RESULT_FRONT_MESSAGE);
    }

    public static void printRoundResult(CarsDto carsDto) {
        for (CarDto carDto : carsDto.getCarsDto()) {
            System.out.println(carDto.getName() + ROUND_REGEX + POSITION_SIGNATURE.repeat(carDto.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(CarsDto winnerCars) {
        StringBuilder result = new StringBuilder();
        for (CarDto winnerCar : winnerCars.getCarsDto()) {
            result.append(winnerCar.getName()).append(WINNER_REGEX);
        }
        System.out.println(result.substring(0, result.length() - 2) + WINNER_RESULT_LAST_MESSAGE);
    }
}
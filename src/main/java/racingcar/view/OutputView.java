package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String CAR_JOIN_DELIMITER = " : ";
    private static final String MOVE_EXPRESSION = "-";
    private static final String WINNER_JOIN_DELIMITER = ", ";

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printCarsPosition(Cars cars) {
        List<CarDto> carDtos = cars.getCarDtos();
        for (CarDto carDto : carDtos) {
            printCarPosition(carDto);
        }
        System.out.println();
    }

    private static void printCarPosition(CarDto carDto) {
        String name = carDto.getName();
        int position = carDto.getPosition();
        System.out.println(name + CAR_JOIN_DELIMITER + MOVE_EXPRESSION.repeat(Math.max(0, position)));
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinners(List<Car> winnerCars) {
        List<String> winnerCarNames = getWinnerCarNames(winnerCars);
        System.out.println(String.join(WINNER_JOIN_DELIMITER, winnerCarNames) + WINNER_MESSAGE);
    }

    private static List<String> getWinnerCarNames(List<Car> winnerCars) {
        List<String> winner = new ArrayList<>();
        for (Car winnerCar : winnerCars) {
            winner.add(winnerCar.getName());
        }
        return winner;
    }

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}

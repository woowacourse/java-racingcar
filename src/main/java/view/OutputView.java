package view;

import domain.Car;
import domain.Cars;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ENTER_TRY_TIMES = "시도할 회수는 몇회인가요?";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String POSITION_BAR = "-";
    private static final String RESULT = "실행 결과";
    private static final String FINAL_WINNER = "가 최종 우승했습니다.";

    public static void printInputCarNamesNotice() {
        System.out.println(ENTER_CAR_NAME);
    }

    public static void printInputTryTimesNotice() {
        System.out.println(ENTER_TRY_TIMES);
    }

    public static void printCarNameAndPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            String carName = car.getName();
            int position = car.getPosition();
            System.out.println(carName + " : " + POSITION_BAR.repeat(position));
        }
        System.out.println();
    }

    public static void printResultNotice() {
        System.out.println(RESULT);
    }

    public static void printWinner(List<Car> winnerCars) {
        List<String> winnerCarNames = winnerCars.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(String.join(WINNER_NAME_DELIMITER, winnerCarNames) + FINAL_WINNER);
    }
}
package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static final String RACING_GAME_WINNERS_MESSAGE = "가 최종우승했습니다.";
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_NUM_OF_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RACING_RESULT_MESSAGE = "실행 결과";

    private OutputView() {}

    public static void printRaceResultMessage() {
        System.out.println();
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public static void printInputCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void printInputNumOfRoundMessage() {
        System.out.println(INPUT_NUM_OF_ROUND_MESSAGE);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printCars(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.displayCurrentStatus()));
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println(winners + RACING_GAME_WINNERS_MESSAGE);
    }
}

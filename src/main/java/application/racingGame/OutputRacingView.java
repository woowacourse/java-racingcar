package application.racingGame;

import java.util.List;

public class OutputRacingView {
    public static final String MOVE_FORWARD = "-";
    public static final String CAR_NAME_DELIMITER = ", ";

    public static void startRacingGameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void getRacingLabMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printPositionDuringRacing(List<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printCarPositionUsingBar(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printCarPositionUsingBar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(MOVE_FORWARD);
        }
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(CAR_NAME_DELIMITER, winners) + "가 최종 우승했습니다.");
    }
}

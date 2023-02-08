package view;

<<<<<<< HEAD
import racingcar.Car;

import java.util.List;

public class OutputView {
    private OutputView() {
        throw new IllegalStateException("생성할 수 없는 유틸 클래스입니다.");
    }

    public static void readCarNames() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void readNumberOfTry() {
        println("시도할 회수는 몇회인가요?");
    }

    public static void printCarsStatus(List<Car> cars) {
        cars.forEach(car -> println(car.getName() + " : " + getPositionBars(car.getPosition())));
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static String getPositionBars(int position) {
        return "-".repeat(position);
    }

    public static void printWinners(List<String> winnerNames) {
        println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public static void printException(String exceptionMessage) {
        println("[ERROR] " + exceptionMessage);
    }

    private static void println(String value) {
=======
import java.io.IOException;

import static constant.Constants.READ_CAR_NAMES;

public class OutputView {
    public void readCarNames() {
        print(READ_CAR_NAMES);
    }

    public void printException(IOException ioException) {
        print(ioException.getMessage());
    }

    private void print(String value) {
>>>>>>> 984262c (feat: 자동차 이름 입력)
        System.out.println(value);
    }
}

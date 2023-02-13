package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public void readNumberOfTry() {
        println("시도할 회수는 몇회인가요?");
    }

    public void printCarsStatus(List<Car> cars) {
        cars.forEach(car -> println(car.getName() + " : " + getPositionBars(car.getPosition())));
        printNewLine();
    }

    private void printNewLine() {
        System.out.println();
    }

    private String getPositionBars(int position) {
        return "-".repeat(position);
    }

    public void printWinners(List<String> winnerNames) {
        println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public void printException(String exceptionMessage) {
        println("[ERROR] " + exceptionMessage);
    }

    private void println(String value) {
        System.out.println(value);
    }
}

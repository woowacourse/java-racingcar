package view;

import domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final char newLine = '\n';

    public void printCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printCurrentResult(List<Car> carsInfo) {
        for (Car car : carsInfo) {
            printCarInfo(car);
        }
        System.out.print(newLine);
    }

    private void printCarInfo(Car car) {
        System.out.print(car.getCarName() + " : ");
        for (int start = 0; start < car.getDistance(); start++) {
            System.out.print('-');
        }
        System.out.print(newLine);
    }

    private void printWinners(List<String> winners) {
        StringJoiner winnerPrintFormat = new StringJoiner(", ");
        for (String winner : winners) {
            winnerPrintFormat.add(winner);
        }
        System.out.print(winnerPrintFormat + "가 최종 우승했습니다.");
    }

    public void printFinalResult(List<Car> carsInfo, List<String> winners) {
        printCurrentResult(carsInfo);
        printWinners(winners);
    }
}
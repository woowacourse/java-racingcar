package view;

import domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    public void printCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printCurrentResult(List<Car> carsInfo) {
        for (Car car : carsInfo) {
            car.printCarInfo();
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        StringJoiner winnerPrintFormat = new StringJoiner(", ");
        for (String winner : winners) {
            winnerPrintFormat.add(winner);
        }
        System.out.println(winnerPrintFormat);
    }
}
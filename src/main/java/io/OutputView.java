package io;

import domain.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void printMoveResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printCarsPosition(final List<Car> cars) {
        for (Car car : cars) {
            String positionBar = createPositionBar(car.getPosition());
            System.out.println(String.format("%s : %s", car.getName(), positionBar));
        }
        System.out.println();
    }

    private String createPositionBar(int position) {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionBar.append("-");
        }
        return positionBar.toString();
    }

    public void printWinners(List<String> winners) {
        StringJoiner winnerJoiner = new StringJoiner(", ");
        for (String winner : winners) {
            winnerJoiner.add(winner);
        }

        System.out.println(String.format("%s가 최종 우승했습니다.", winnerJoiner));
    }
}

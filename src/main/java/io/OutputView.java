package io;

import domain.Car;

import java.util.List;

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
}

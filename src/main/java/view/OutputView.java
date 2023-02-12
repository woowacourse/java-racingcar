package view;

import domain.Car;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_NAME_FORMAT = " : ";
    private static final String MOVEMENT = "-";
    private static final String END_MESSAGE = "가 최종 우승했습니다.";
    private static final String DIVISION_CHAR = ",";

    public void printAllStatus(List<Car> carInformation) {
        System.out.println(RESULT_MESSAGE);
        for (Car car : carInformation) {
            System.out.print(car.getName()+CAR_NAME_FORMAT);
            printPositionByName(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public void printPositionByName(int position) {
        for (int count = 0; count < position; count++) {
            System.out.print(MOVEMENT);
        }
    }


    public void printWinners(List<String> winners) {
        System.out.println(winnerFormat(winners) + END_MESSAGE);
    }

    private String winnerFormat(List<String> winners) {
        return String.join(DIVISION_CHAR, winners);
    }
}


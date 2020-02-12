package view;

import model.Car;

import java.util.List;

public class OutputView {

    public static final String COLON = " : ";
    public static final String BLANK = "\0";
    public static final String SCORE_BAR = "-";
    public static final String COMMA = ",";
    public static final String WINNER_MESSAGE_FOOTER = " 가 우승했습니다.";
    public static final String BEGIN_RESULT_MESSAGE = "실행 결과";

    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + COLON + printPositionBar(car));
        }
        System.out.println();
    }

    public static String printPositionBar(Car car) {
        int position = car.getPosition();
        return makePositionBar(position);
    }

    private static String makePositionBar(int position) {
        return new String(new char[position]).replace(BLANK, SCORE_BAR);
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(COMMA, winners);
        System.out.println(winner + WINNER_MESSAGE_FOOTER);
    }

    public static void printBeginResult() {
        System.out.println(BEGIN_RESULT_MESSAGE);
    }
}

package racingcargame.view;

import racingcargame.domain.Car;

public class OutputView {
    private static final String MARK = "-";

    public static void printRaceResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceStatus(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getCarName());
        sb.append(" : ");
        for (int i = 0; i < car.getCarPosition(); i++) {
            sb.append(MARK);
        }
        System.out.println(sb);
    }

    public static void printWinner(String winnerName) {
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}

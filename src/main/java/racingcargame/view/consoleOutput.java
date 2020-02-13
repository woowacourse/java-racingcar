package racingcargame.view;

import racingcargame.domain.Car;

class consoleOutput {

    private static final String MARK = "-";
    private static final String SEPARATOR = " : ";

    static void printRaceResultMessage() {
        System.out.println("\n실행 결과");
    }

    static void printRaceStatus(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getCarName());
        sb.append(SEPARATOR);
        printEachStatus(car, sb);
        System.out.println(sb);
    }

    private static void printEachStatus(Car car, StringBuilder sb) {
        for (int i = 0; i < car.getCarPosition(); i++) {
            sb.append(MARK);
        }
    }

    static void printWinner(String winnerName) {
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }
}

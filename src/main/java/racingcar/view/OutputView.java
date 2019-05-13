package racingcar.view;

import racingcar.domain.RaceStatus;

public class OutputView {
    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }
    public static void printEachRound(RaceStatus status) {
        status.getCurrentStatus().forEach(
                car -> System.out.println(car + " : " + drawTrail(car.getPosition()))
        );
        System.out.println();
    }

    private static String drawTrail(int position) {
        StringBuffer trail = new StringBuffer();
        for (int i = 0; i < position; i++) {
            trail.append("-");
        }
        return trail.toString();
    }

    public static void printWinners(RaceStatus status) {
        String result = status.getNameOfWinners().toString();
        result = result.substring(1, result.length() - 1);
        System.out.println(
                result
                + HangulPostposition.differentiateIGa(result)
                + " 최종 우승했습니다."
        );
    }
}
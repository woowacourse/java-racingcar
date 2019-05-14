package racingcar.view;

import racingcar.domain.RaceResult;

public class OutputView {
    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }
    public static void printEachRound(RaceResult result) {
        result.getResult().entrySet().forEach(
                car -> System.out.println(car.getKey() + " : " + drawTrail(car.getValue()))
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

    public static void printWinners(RaceResult result) {
        String names = result.getWinners().keySet().toString();
        names = names.substring(1, names.length() - 1);
        System.out.println(
                names
                + HangulPostposition.differentiateIGa(names)
                + " 최종 우승했습니다."
        );
    }
}